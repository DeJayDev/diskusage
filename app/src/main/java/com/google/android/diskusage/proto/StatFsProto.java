// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.google.android.diskusage.proto;

@SuppressWarnings("hiding")
public final class StatFsProto extends
    com.google.protobuf.nano.MessageNano {

  private static volatile StatFsProto[] _emptyArray;
  public static StatFsProto[] emptyArray() {
    // Lazily initializes the empty array
    if (_emptyArray == null) {
      synchronized (
          com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
        if (_emptyArray == null) {
          _emptyArray = new StatFsProto[0];
        }
      }
    }
    return _emptyArray;
  }

  // optional string mount_point = 1;
  public java.lang.String mountPoint;

  // optional int32 available_blocks = 2;
  public int availableBlocks;

  // optional int64 available_blocks_long = 3;
  public long availableBlocksLong;

  // optional int64 available_bytes = 4;
  public long availableBytes;

  // optional int32 block_count = 5;
  public int blockCount;

  // optional int64 block_count_long = 6;
  public long blockCountLong;

  // optional int32 block_size = 7;
  public long blockSize;

  // optional int64 free_bytes = 9;
  public long freeBytes;

  // optional int32 free_blocks = 10;
  public int freeBlocks;

  // optional int64 free_blocks_long = 11;
  public long freeBlocksLong;

  // optional int64 total_bytes = 12;
  public long totalBytes;

  public StatFsProto() {
    clear();
  }

  public StatFsProto clear() {
    mountPoint = "";
    availableBlocks = 0;
    availableBlocksLong = 0L;
    availableBytes = 0L;
    blockCount = 0;
    blockCountLong = 0L;
    blockSize = 0L;
    freeBytes = 0L;
    freeBlocks = 0;
    freeBlocksLong = 0L;
    totalBytes = 0L;
    cachedSize = -1;
    return this;
  }

  @Override
  public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
      throws java.io.IOException {
    if (!this.mountPoint.equals("")) {
      output.writeString(1, this.mountPoint);
    }
    if (this.availableBlocks != 0) {
      output.writeInt32(2, this.availableBlocks);
    }
    if (this.availableBlocksLong != 0L) {
      output.writeInt64(3, this.availableBlocksLong);
    }
    if (this.availableBytes != 0L) {
      output.writeInt64(4, this.availableBytes);
    }
    if (this.blockCount != 0) {
      output.writeInt32(5, this.blockCount);
    }
    if (this.blockCountLong != 0L) {
      output.writeInt64(6, this.blockCountLong);
    }
    if (this.blockSize != 0) {
      output.writeInt64(7, this.blockSize);
    }
    if (this.freeBytes != 0L) {
      output.writeInt64(9, this.freeBytes);
    }
    if (this.freeBlocks != 0) {
      output.writeInt32(10, this.freeBlocks);
    }
    if (this.freeBlocksLong != 0L) {
      output.writeInt64(11, this.freeBlocksLong);
    }
    if (this.totalBytes != 0L) {
      output.writeInt64(12, this.totalBytes);
    }
    super.writeTo(output);
  }

  @Override
  protected int computeSerializedSize() {
    int size = super.computeSerializedSize();
    if (!this.mountPoint.equals("")) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeStringSize(1, this.mountPoint);
    }
    if (this.availableBlocks != 0) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(2, this.availableBlocks);
    }
    if (this.availableBlocksLong != 0L) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt64Size(3, this.availableBlocksLong);
    }
    if (this.availableBytes != 0L) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt64Size(4, this.availableBytes);
    }
    if (this.blockCount != 0) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(5, this.blockCount);
    }
    if (this.blockCountLong != 0L) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt64Size(6, this.blockCountLong);
    }
    if (this.blockSize != 0) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt64Size(7, this.blockSize);
    }
    if (this.freeBytes != 0L) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt64Size(9, this.freeBytes);
    }
    if (this.freeBlocks != 0) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(10, this.freeBlocks);
    }
    if (this.freeBlocksLong != 0L) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt64Size(11, this.freeBlocksLong);
    }
    if (this.totalBytes != 0L) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt64Size(12, this.totalBytes);
    }
    return size;
  }

  @Override
  public StatFsProto mergeFrom(
          com.google.protobuf.nano.CodedInputByteBufferNano input)
      throws java.io.IOException {
    while (true) {
      int tag = input.readTag();
      switch (tag) {
        case 0:
          return this;
        default: {
          if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
            return this;
          }
          break;
        }
        case 10: {
          this.mountPoint = input.readString();
          break;
        }
        case 16: {
          this.availableBlocks = input.readInt32();
          break;
        }
        case 24: {
          this.availableBlocksLong = input.readInt64();
          break;
        }
        case 32: {
          this.availableBytes = input.readInt64();
          break;
        }
        case 40: {
          this.blockCount = input.readInt32();
          break;
        }
        case 48: {
          this.blockCountLong = input.readInt64();
          break;
        }
        case 56: {
          this.blockSize = input.readInt64();
          break;
        }
        case 72: {
          this.freeBytes = input.readInt64();
          break;
        }
        case 80: {
          this.freeBlocks = input.readInt32();
          break;
        }
        case 88: {
          this.freeBlocksLong = input.readInt64();
          break;
        }
        case 96: {
          this.totalBytes = input.readInt64();
          break;
        }
      }
    }
  }

  public static StatFsProto parseFrom(byte[] data)
      throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
    return com.google.protobuf.nano.MessageNano.mergeFrom(new StatFsProto(), data);
  }

  public static StatFsProto parseFrom(
          com.google.protobuf.nano.CodedInputByteBufferNano input)
      throws java.io.IOException {
    return new StatFsProto().mergeFrom(input);
  }
}
