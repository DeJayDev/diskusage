// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.google.android.diskusage.proto;

@SuppressWarnings("hiding")
public final class PortableExceptionProto extends
    com.google.protobuf.nano.MessageNano {

  private static volatile PortableExceptionProto[] _emptyArray;

  public static PortableExceptionProto[] emptyArray() {
    // Lazily initializes the empty array
    if (_emptyArray == null) {
      synchronized (
          com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
        if (_emptyArray == null) {
          _emptyArray = new PortableExceptionProto[0];
        }
      }
    }
    return _emptyArray;
  }

  // optional string class = 1;
  public java.lang.String class_;

  // optional string msg = 2;
  public java.lang.String msg;

  // optional string stack = 3;
  public java.lang.String stack;

  public PortableExceptionProto() {
    clear();
  }

  public PortableExceptionProto clear() {
    class_ = "";
    msg = "";
    stack = "";
    cachedSize = -1;
    return this;
  }

  @Override
  public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
      throws java.io.IOException {
    if (!this.class_.equals("")) {
      output.writeString(1, this.class_);
    }
    if (!this.msg.equals("")) {
      output.writeString(2, this.msg);
    }
    if (!this.stack.equals("")) {
      output.writeString(3, this.stack);
    }
    super.writeTo(output);
  }

  @Override
  protected int computeSerializedSize() {
    int size = super.computeSerializedSize();
    if (!this.class_.equals("")) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeStringSize(1, this.class_);
    }
    if (!this.msg.equals("")) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeStringSize(2, this.msg);
    }
    if (!this.stack.equals("")) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeStringSize(3, this.stack);
    }
    return size;
  }

  @Override
  public PortableExceptionProto mergeFrom(
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
          this.class_ = input.readString();
          break;
        }
        case 18: {
          this.msg = input.readString();
          break;
        }
        case 26: {
          this.stack = input.readString();
          break;
        }
      }
    }
  }

  public static PortableExceptionProto parseFrom(byte[] data)
      throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
    return com.google.protobuf.nano.MessageNano.mergeFrom(new PortableExceptionProto(), data);
  }

  public static PortableExceptionProto parseFrom(
      com.google.protobuf.nano.CodedInputByteBufferNano input)
      throws java.io.IOException {
    return new PortableExceptionProto().mergeFrom(input);
  }
}
