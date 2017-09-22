package com.dkohut.bookchat.client.common.entity;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: BookService.proto")
public final class BookServiceGrpc {

  private BookServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dkohut.bookchat.client.common.entity.BookService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dkohut.bookchat.client.common.entity.Book,
      com.dkohut.bookchat.client.common.entity.ResponseMessage> METHOD_CREATE_BOOK =
      io.grpc.MethodDescriptor.<com.dkohut.bookchat.client.common.entity.Book, com.dkohut.bookchat.client.common.entity.ResponseMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dkohut.bookchat.client.common.entity.BookService", "createBook"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.client.common.entity.Book.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.client.common.entity.ResponseMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dkohut.bookchat.client.common.entity.SearchBookMessage,
      com.dkohut.bookchat.client.common.entity.Book> METHOD_SEARCH_BOOK =
      io.grpc.MethodDescriptor.<com.dkohut.bookchat.client.common.entity.SearchBookMessage, com.dkohut.bookchat.client.common.entity.Book>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dkohut.bookchat.client.common.entity.BookService", "searchBook"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.client.common.entity.SearchBookMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.client.common.entity.Book.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dkohut.bookchat.client.common.entity.DeleteBookMessage,
      com.dkohut.bookchat.client.common.entity.ResponseMessage> METHOD_DELETE_BOOK =
      io.grpc.MethodDescriptor.<com.dkohut.bookchat.client.common.entity.DeleteBookMessage, com.dkohut.bookchat.client.common.entity.ResponseMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dkohut.bookchat.client.common.entity.BookService", "deleteBook"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.client.common.entity.DeleteBookMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.client.common.entity.ResponseMessage.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookServiceStub newStub(io.grpc.Channel channel) {
    return new BookServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BookServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Method for adding new book
     * </pre>
     */
    public void createBook(com.dkohut.bookchat.client.common.entity.Book request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_BOOK, responseObserver);
    }

    /**
     * <pre>
     * Method for searching existing book
     * </pre>
     */
    public void searchBook(com.dkohut.bookchat.client.common.entity.SearchBookMessage request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.Book> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_BOOK, responseObserver);
    }

    /**
     * <pre>
     * Method for deleting existing book
     * </pre>
     */
    public void deleteBook(com.dkohut.bookchat.client.common.entity.DeleteBookMessage request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_BOOK, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_BOOK,
            asyncUnaryCall(
              new MethodHandlers<
                com.dkohut.bookchat.client.common.entity.Book,
                com.dkohut.bookchat.client.common.entity.ResponseMessage>(
                  this, METHODID_CREATE_BOOK)))
          .addMethod(
            METHOD_SEARCH_BOOK,
            asyncUnaryCall(
              new MethodHandlers<
                com.dkohut.bookchat.client.common.entity.SearchBookMessage,
                com.dkohut.bookchat.client.common.entity.Book>(
                  this, METHODID_SEARCH_BOOK)))
          .addMethod(
            METHOD_DELETE_BOOK,
            asyncUnaryCall(
              new MethodHandlers<
                com.dkohut.bookchat.client.common.entity.DeleteBookMessage,
                com.dkohut.bookchat.client.common.entity.ResponseMessage>(
                  this, METHODID_DELETE_BOOK)))
          .build();
    }
  }

  /**
   */
  public static final class BookServiceStub extends io.grpc.stub.AbstractStub<BookServiceStub> {
    private BookServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for adding new book
     * </pre>
     */
    public void createBook(com.dkohut.bookchat.client.common.entity.Book request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_BOOK, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method for searching existing book
     * </pre>
     */
    public void searchBook(com.dkohut.bookchat.client.common.entity.SearchBookMessage request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.Book> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH_BOOK, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method for deleting existing book
     * </pre>
     */
    public void deleteBook(com.dkohut.bookchat.client.common.entity.DeleteBookMessage request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_BOOK, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookServiceBlockingStub extends io.grpc.stub.AbstractStub<BookServiceBlockingStub> {
    private BookServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for adding new book
     * </pre>
     */
    public com.dkohut.bookchat.client.common.entity.ResponseMessage createBook(com.dkohut.bookchat.client.common.entity.Book request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_BOOK, getCallOptions(), request);
    }

    /**
     * <pre>
     * Method for searching existing book
     * </pre>
     */
    public com.dkohut.bookchat.client.common.entity.Book searchBook(com.dkohut.bookchat.client.common.entity.SearchBookMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH_BOOK, getCallOptions(), request);
    }

    /**
     * <pre>
     * Method for deleting existing book
     * </pre>
     */
    public com.dkohut.bookchat.client.common.entity.ResponseMessage deleteBook(com.dkohut.bookchat.client.common.entity.DeleteBookMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_BOOK, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookServiceFutureStub extends io.grpc.stub.AbstractStub<BookServiceFutureStub> {
    private BookServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for adding new book
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dkohut.bookchat.client.common.entity.ResponseMessage> createBook(
        com.dkohut.bookchat.client.common.entity.Book request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_BOOK, getCallOptions()), request);
    }

    /**
     * <pre>
     * Method for searching existing book
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dkohut.bookchat.client.common.entity.Book> searchBook(
        com.dkohut.bookchat.client.common.entity.SearchBookMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH_BOOK, getCallOptions()), request);
    }

    /**
     * <pre>
     * Method for deleting existing book
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dkohut.bookchat.client.common.entity.ResponseMessage> deleteBook(
        com.dkohut.bookchat.client.common.entity.DeleteBookMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_BOOK, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BOOK = 0;
  private static final int METHODID_SEARCH_BOOK = 1;
  private static final int METHODID_DELETE_BOOK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BOOK:
          serviceImpl.createBook((com.dkohut.bookchat.client.common.entity.Book) request,
              (io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.ResponseMessage>) responseObserver);
          break;
        case METHODID_SEARCH_BOOK:
          serviceImpl.searchBook((com.dkohut.bookchat.client.common.entity.SearchBookMessage) request,
              (io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.Book>) responseObserver);
          break;
        case METHODID_DELETE_BOOK:
          serviceImpl.deleteBook((com.dkohut.bookchat.client.common.entity.DeleteBookMessage) request,
              (io.grpc.stub.StreamObserver<com.dkohut.bookchat.client.common.entity.ResponseMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class BookServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dkohut.bookchat.client.common.entity.BookServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_BOOK)
              .addMethod(METHOD_SEARCH_BOOK)
              .addMethod(METHOD_DELETE_BOOK)
              .build();
        }
      }
    }
    return result;
  }
}
