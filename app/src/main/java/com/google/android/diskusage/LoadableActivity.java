/**
 * DiskUsage - displays sdcard usage on android. Copyright (C) 2008-2011 Ivan Volosyuk
 * <p>
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package com.google.android.diskusage;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.diskusage.DiskUsage.AfterLoad;
import com.google.android.diskusage.entity.FileSystemEntry;
import com.google.android.diskusage.entity.FileSystemPackage;
import com.google.android.diskusage.entity.FileSystemSuperRoot;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public abstract class LoadableActivity extends Activity {

  FileSystemPackage pkg_removed;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FileSystemEntry.setupStrings(this);
  }

  public abstract String getKey();

  abstract FileSystemSuperRoot scan() throws IOException, InterruptedException;

  static class PersistantActivityState {

    FileSystemSuperRoot root;
    AfterLoad afterLoad;
    MyProgressDialog loading;
  }

  private static final Map<String, PersistantActivityState> persistantActivityState =
      new TreeMap<>();

  public static void resetStoredStates() {
    persistantActivityState.clear();
  }


  // FIXME: use it wisely
  static boolean forceCleanup() {
    boolean success = false;
    for (PersistantActivityState state : persistantActivityState.values()) {
      if (state.afterLoad == null && state.root != null) {
        state.root = null;
        success = true;
      }
    }
    return success;
  }

  protected PersistantActivityState getPersistantState() {
    String key = getKey();

    PersistantActivityState state = persistantActivityState.get(key);
    if (state != null) {
      return state;
    }
    state = new PersistantActivityState();
    persistantActivityState.put(key, state);
    return state;
  }

  void LoadFiles(final LoadableActivity activity,
      final AfterLoad runAfterLoad, boolean force) {
    boolean scanRunning;
    final PersistantActivityState state = getPersistantState();
    Log.d("diskusage", "LoadFiles, afterLoad = " + runAfterLoad);

    if (force) {
      state.root = null;
    }

    if (state.root != null) {
      runAfterLoad.run(state.root, true);
      return;
    }

    scanRunning = state.afterLoad != null;
    state.afterLoad = runAfterLoad;
    Log.d("diskusage", "created new progress dialog");
    state.loading = new MyProgressDialog(activity);

    final MyProgressDialog thisLoading = state.loading;
    state.loading.setOnCancelListener(dialog -> {
      state.loading = null;
      activity.finish();
    });
    thisLoading.setCancelable(true);
//    thisLoading.setIndeterminate(true);
    thisLoading.setMax(1);
    thisLoading.setMessage(activity.getString(R.string.scaning_directories));
    thisLoading.show();

    if (scanRunning) {
      return;
    }
    final Handler handler = new Handler();

    new Thread(() -> {
      String error;
      try {
        Log.d("diskusage", "running scan for " + getKey());
        final FileSystemSuperRoot newRoot = scan();

        handler.post(() -> {
          if (state.loading == null) {
            Log.d("diskusage", "no dialog, doesn't run afterLoad");
            state.afterLoad = null;
            if (newRoot.children[0].children != null) {
              Log.d("diskusage", "no dialog, updating root still");
              state.root = newRoot;
            }
            return;
          }
          if (state.loading.isShowing()) {
            state.loading.dismiss();
          }
          state.loading = null;
          AfterLoad afterLoadCopy = state.afterLoad;
          state.afterLoad = null;
          Log.d("diskusage", "dismissed dialog");

          if (newRoot.children[0].children == null) {
            Log.d("diskusage", "empty card");
            handleEmptySDCard(activity, runAfterLoad);
            return;
          }
          state.root = newRoot;
          pkg_removed = null;
          Log.d("diskusage", "run afterLoad = " + afterLoadCopy);
          afterLoadCopy.run(state.root, false);
        });
        return;
      } catch (final OutOfMemoryError e) {
        state.root = null;
        state.afterLoad = null;
        Log.d("DiskUsage", "out of memory!");
        handler.post(() -> {
          if (state.loading == null) {
            return;
          }
          state.loading.dismiss();
          handleOutOfMemory(activity);
        });
        return;
      } catch (InterruptedException | IOException | RuntimeException e) {
        error = e.getClass().getName() + ":" + e.getMessage();
        Log.e("diskusage", "native error", e);
      } catch (final StackOverflowError e) {
        error = "Filesystem is damaged.";
      }
      final String finalError = error;
      state.root = null;
      state.afterLoad = null;
      Log.d("DiskUsage", "exception in scan!");
      handler.post(() -> {
        if (state.loading == null) {
          return;
        }
        state.loading.dismiss();
        new AlertDialog.Builder(activity)
            .setTitle(finalError)
            .setOnCancelListener(dialog -> activity.finish()).create().show();

      });
    }).start();
  }

  @Override
  protected void onPause() {
    PersistantActivityState state = getPersistantState();
    if (state.loading != null) {
      if (state.loading.isShowing()) {
        state.loading.dismiss();
      }
      Log.d("diskusage", "removed progress dialog");
      state.loading = null;
    }
    super.onPause();
  }

  private void handleEmptySDCard(final LoadableActivity activity,
      final AfterLoad afterLoad) {
    new AlertDialog.Builder(activity)
        .setTitle(activity.getString(R.string.empty_or_missing_sdcard))
        .setPositiveButton(activity.getString(R.string.button_rescan), (dialog, which) -> {
          if (afterLoad == null) {
            throw new RuntimeException("afterLoad is empty");
          }
          LoadFiles(activity, afterLoad, true);
        })
        .setOnCancelListener(dialog -> activity.finish()).create().show();
  }

  private static void handleOutOfMemory(final Activity activity) {
    try {
      // Can fail if the main window is already closed.
      new AlertDialog.Builder(activity)
          .setTitle(activity.getString(R.string.out_of_memory))
          .setOnCancelListener(dialog -> activity.finish()).create().show();
    } catch (Throwable t) {
      Toast.makeText(
          activity, "DiskUsage is out of memory. Sorry.", Toast.LENGTH_SHORT).show();
    }
  }
}
