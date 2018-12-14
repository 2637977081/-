package com.univer.base.grpc.storage;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: storage.proto")
public final class StorageServiceGrpc {

  private StorageServiceGrpc() {}

  public static final String SERVICE_NAME = "storage.StorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.univer.base.grpc.storage.StorageRequest,
      com.univer.base.grpc.storage.StorageResponse> getObjectStorageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "objectStorage",
      requestType = com.univer.base.grpc.storage.StorageRequest.class,
      responseType = com.univer.base.grpc.storage.StorageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.univer.base.grpc.storage.StorageRequest,
      com.univer.base.grpc.storage.StorageResponse> getObjectStorageMethod() {
    io.grpc.MethodDescriptor<com.univer.base.grpc.storage.StorageRequest, com.univer.base.grpc.storage.StorageResponse> getObjectStorageMethod;
    if ((getObjectStorageMethod = StorageServiceGrpc.getObjectStorageMethod) == null) {
      synchronized (StorageServiceGrpc.class) {
        if ((getObjectStorageMethod = StorageServiceGrpc.getObjectStorageMethod) == null) {
          StorageServiceGrpc.getObjectStorageMethod = getObjectStorageMethod = 
              io.grpc.MethodDescriptor.<com.univer.base.grpc.storage.StorageRequest, com.univer.base.grpc.storage.StorageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "storage.StorageService", "objectStorage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.storage.StorageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.storage.StorageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageServiceMethodDescriptorSupplier("objectStorage"))
                  .build();
          }
        }
     }
     return getObjectStorageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.univer.base.grpc.storage.StorageRequest,
      com.univer.base.grpc.storage.StorageResponse> getLogStorageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logStorage",
      requestType = com.univer.base.grpc.storage.StorageRequest.class,
      responseType = com.univer.base.grpc.storage.StorageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.univer.base.grpc.storage.StorageRequest,
      com.univer.base.grpc.storage.StorageResponse> getLogStorageMethod() {
    io.grpc.MethodDescriptor<com.univer.base.grpc.storage.StorageRequest, com.univer.base.grpc.storage.StorageResponse> getLogStorageMethod;
    if ((getLogStorageMethod = StorageServiceGrpc.getLogStorageMethod) == null) {
      synchronized (StorageServiceGrpc.class) {
        if ((getLogStorageMethod = StorageServiceGrpc.getLogStorageMethod) == null) {
          StorageServiceGrpc.getLogStorageMethod = getLogStorageMethod = 
              io.grpc.MethodDescriptor.<com.univer.base.grpc.storage.StorageRequest, com.univer.base.grpc.storage.StorageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage.StorageService", "logStorage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.storage.StorageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.storage.StorageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageServiceMethodDescriptorSupplier("logStorage"))
                  .build();
          }
        }
     }
     return getLogStorageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StorageServiceStub newStub(io.grpc.Channel channel) {
    return new StorageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StorageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StorageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StorageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageRequest> objectStorage(
        io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getObjectStorageMethod(), responseObserver);
    }

    /**
     */
    public void logStorage(com.univer.base.grpc.storage.StorageRequest request,
        io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogStorageMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getObjectStorageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.univer.base.grpc.storage.StorageRequest,
                com.univer.base.grpc.storage.StorageResponse>(
                  this, METHODID_OBJECT_STORAGE)))
          .addMethod(
            getLogStorageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.univer.base.grpc.storage.StorageRequest,
                com.univer.base.grpc.storage.StorageResponse>(
                  this, METHODID_LOG_STORAGE)))
          .build();
    }
  }

  /**
   */
  public static final class StorageServiceStub extends io.grpc.stub.AbstractStub<StorageServiceStub> {
    private StorageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StorageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageRequest> objectStorage(
        io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getObjectStorageMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void logStorage(com.univer.base.grpc.storage.StorageRequest request,
        io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogStorageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StorageServiceBlockingStub extends io.grpc.stub.AbstractStub<StorageServiceBlockingStub> {
    private StorageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StorageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.univer.base.grpc.storage.StorageResponse logStorage(com.univer.base.grpc.storage.StorageRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogStorageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StorageServiceFutureStub extends io.grpc.stub.AbstractStub<StorageServiceFutureStub> {
    private StorageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StorageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.univer.base.grpc.storage.StorageResponse> logStorage(
        com.univer.base.grpc.storage.StorageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogStorageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOG_STORAGE = 0;
  private static final int METHODID_OBJECT_STORAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StorageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StorageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOG_STORAGE:
          serviceImpl.logStorage((com.univer.base.grpc.storage.StorageRequest) request,
              (io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OBJECT_STORAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.objectStorage(
              (io.grpc.stub.StreamObserver<com.univer.base.grpc.storage.StorageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.univer.base.grpc.storage.Storage.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StorageService");
    }
  }

  private static final class StorageServiceFileDescriptorSupplier
      extends StorageServiceBaseDescriptorSupplier {
    StorageServiceFileDescriptorSupplier() {}
  }

  private static final class StorageServiceMethodDescriptorSupplier
      extends StorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StorageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StorageServiceFileDescriptorSupplier())
              .addMethod(getObjectStorageMethod())
              .addMethod(getLogStorageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
