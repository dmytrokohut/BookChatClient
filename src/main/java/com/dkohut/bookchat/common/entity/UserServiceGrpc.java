package com.dkohut.bookchat.common.entity;

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
 * <pre>
 * Service that controll activity related to user
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: UserService.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dkohut.bookchat.common.entity.UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dkohut.bookchat.common.entity.User,
      com.dkohut.bookchat.common.entity.ResponseMessage> METHOD_REGISTRATION =
      io.grpc.MethodDescriptor.<com.dkohut.bookchat.common.entity.User, com.dkohut.bookchat.common.entity.ResponseMessage>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dkohut.bookchat.common.entity.UserService", "registration"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.common.entity.User.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.common.entity.ResponseMessage.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.dkohut.bookchat.common.entity.LoginMessage,
      com.dkohut.bookchat.common.entity.User> METHOD_LOGIN =
      io.grpc.MethodDescriptor.<com.dkohut.bookchat.common.entity.LoginMessage, com.dkohut.bookchat.common.entity.User>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.dkohut.bookchat.common.entity.UserService", "login"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.common.entity.LoginMessage.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.dkohut.bookchat.common.entity.User.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service that controll activity related to user
   * </pre>
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Method for registration new user in the system
     * </pre>
     */
    public void registration(com.dkohut.bookchat.common.entity.User request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.common.entity.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGISTRATION, responseObserver);
    }

    /**
     * <pre>
     * Method for login an existing user
     * </pre>
     */
    public void login(com.dkohut.bookchat.common.entity.LoginMessage request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.common.entity.User> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REGISTRATION,
            asyncUnaryCall(
              new MethodHandlers<
                com.dkohut.bookchat.common.entity.User,
                com.dkohut.bookchat.common.entity.ResponseMessage>(
                  this, METHODID_REGISTRATION)))
          .addMethod(
            METHOD_LOGIN,
            asyncUnaryCall(
              new MethodHandlers<
                com.dkohut.bookchat.common.entity.LoginMessage,
                com.dkohut.bookchat.common.entity.User>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   * <pre>
   * Service that controll activity related to user
   * </pre>
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for registration new user in the system
     * </pre>
     */
    public void registration(com.dkohut.bookchat.common.entity.User request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.common.entity.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGISTRATION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method for login an existing user
     * </pre>
     */
    public void login(com.dkohut.bookchat.common.entity.LoginMessage request,
        io.grpc.stub.StreamObserver<com.dkohut.bookchat.common.entity.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service that controll activity related to user
   * </pre>
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for registration new user in the system
     * </pre>
     */
    public com.dkohut.bookchat.common.entity.ResponseMessage registration(com.dkohut.bookchat.common.entity.User request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGISTRATION, getCallOptions(), request);
    }

    /**
     * <pre>
     * Method for login an existing user
     * </pre>
     */
    public com.dkohut.bookchat.common.entity.User login(com.dkohut.bookchat.common.entity.LoginMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service that controll activity related to user
   * </pre>
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for registration new user in the system
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dkohut.bookchat.common.entity.ResponseMessage> registration(
        com.dkohut.bookchat.common.entity.User request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REGISTRATION, getCallOptions()), request);
    }

    /**
     * <pre>
     * Method for login an existing user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dkohut.bookchat.common.entity.User> login(
        com.dkohut.bookchat.common.entity.LoginMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTRATION = 0;
  private static final int METHODID_LOGIN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTRATION:
          serviceImpl.registration((com.dkohut.bookchat.common.entity.User) request,
              (io.grpc.stub.StreamObserver<com.dkohut.bookchat.common.entity.ResponseMessage>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.dkohut.bookchat.common.entity.LoginMessage) request,
              (io.grpc.stub.StreamObserver<com.dkohut.bookchat.common.entity.User>) responseObserver);
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

  private static final class UserServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dkohut.bookchat.common.entity.UserServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceDescriptorSupplier())
              .addMethod(METHOD_REGISTRATION)
              .addMethod(METHOD_LOGIN)
              .build();
        }
      }
    }
    return result;
  }
}
