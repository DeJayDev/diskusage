// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.google.android.diskusage.proto;

@SuppressWarnings("hiding")
public final class PortableStreamProto extends
    com.google.protobuf.nano.MessageNano {

  private static volatile PortableStreamProto[] _emptyArray;

  public static PortableStreamProto[] emptyArray() {
    // Lazily initializes the empty array
    if (_emptyArray == null) {
      synchronized (
          com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
        if (_emptyArray == null) {
          _emptyArray = new PortableStreamProto[0];
        }
      }
    }
    return _emptyArray;
  }

  // optional bytes data = 1;
  public byte[] data;

  // optional .PortableExceptionProto read_exception = 2;
  public com.google.android.diskusage.proto.PortableExceptionProto readException;

  // optional .PortableExceptionProto close_exception = 3;
  public com.google.android.diskusage.proto.PortableExceptionProto closeException;

  public PortableStreamProto() {
    clear();
  }

  public PortableStreamProto clear() {
    data = com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES;
    readException = null;
    closeException = null;
    cachedSize = -1;
    return this;
  }

  @Override
  public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
      throws java.io.IOException {
    if (!java.util.Arrays.equals(this.data, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
      output.writeBytes(1, this.data);
    }
    if (this.readException != null) {
      output.writeMessage(2, this.readException);
    }
    if (this.closeException != null) {
      output.writeMessage(3, this.closeException);
    }
    super.writeTo(output);
  }

  @Override
  protected int computeSerializedSize() {
    int size = super.computeSerializedSize();
    if (!java.util.Arrays.equals(this.data, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeBytesSize(1, this.data);
    }
    if (this.readException != null) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(2, this.readException);
    }
    if (this.closeException != null) {
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(3, this.closeException);
    }
    return size;
  }

  @Override
  public PortableStreamProto mergeFrom(
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
          this.data = input.readBytes();
          break;
        }
        case 18: {
          if (this.readException == null) {
            this.readException = new com.google.android.diskusage.proto.PortableExceptionProto();
          }
          input.readMessage(this.readException);
          break;
        }
        case 26: {
          if (this.closeException == null) {
            this.closeException = new com.google.android.diskusage.proto.PortableExceptionProto();
          }
          input.readMessage(this.closeException);
          break;
        }
      }
    }
  }

  public static PortableStreamProto parseFrom(byte[] data)
      throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
    return com.google.protobuf.nano.MessageNano.mergeFrom(new PortableStreamProto(), data);
  }

  public static PortableStreamProto parseFrom(
      com.google.protobuf.nano.CodedInputByteBufferNano input)
      throws java.io.IOException {
    return new PortableStreamProto().mergeFrom(input);
  }
}
