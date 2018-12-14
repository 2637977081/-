package com.univer.base.grpc.account;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: user.proto")
public final class AccountServiceGrpc {

  private AccountServiceGrpc() {}

  public static final String SERVICE_NAME = "account.AccountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "detail",
      requestType = com.univer.base.grpc.account.AccountRequest.class,
      responseType = com.univer.base.grpc.account.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getDetailMethod() {
    io.grpc.MethodDescriptor<AccountRequest, AccountResponse> getDetailMethod;
    if ((getDetailMethod = AccountServiceGrpc.getDetailMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getDetailMethod = AccountServiceGrpc.getDetailMethod) == null) {
          AccountServiceGrpc.getDetailMethod = getDetailMethod =
              io.grpc.MethodDescriptor.<com.univer.base.grpc.account.AccountRequest, com.univer.base.grpc.account.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "account.AccountService", "detail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("detail"))
                  .build();
          }
        }
     }
     return getDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getListByIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listByIds",
      requestType = com.univer.base.grpc.account.AccountRequest.class,
      responseType = com.univer.base.grpc.account.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getListByIdsMethod() {
    io.grpc.MethodDescriptor<AccountRequest, AccountResponse> getListByIdsMethod;
    if ((getListByIdsMethod = AccountServiceGrpc.getListByIdsMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getListByIdsMethod = AccountServiceGrpc.getListByIdsMethod) == null) {
          AccountServiceGrpc.getListByIdsMethod = getListByIdsMethod =
              io.grpc.MethodDescriptor.<com.univer.base.grpc.account.AccountRequest, com.univer.base.grpc.account.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "account.AccountService", "listByIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("listByIds"))
                  .build();
          }
        }
     }
     return getListByIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getFindDictByTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findDictByType",
      requestType = com.univer.base.grpc.account.AccountRequest.class,
      responseType = com.univer.base.grpc.account.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getFindDictByTypeMethod() {
    io.grpc.MethodDescriptor<AccountRequest, AccountResponse> getFindDictByTypeMethod;
    if ((getFindDictByTypeMethod = AccountServiceGrpc.getFindDictByTypeMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getFindDictByTypeMethod = AccountServiceGrpc.getFindDictByTypeMethod) == null) {
          AccountServiceGrpc.getFindDictByTypeMethod = getFindDictByTypeMethod =
              io.grpc.MethodDescriptor.<com.univer.base.grpc.account.AccountRequest, com.univer.base.grpc.account.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "account.AccountService", "findDictByType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("findDictByType"))
                  .build();
          }
        }
     }
     return getFindDictByTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getFindMapByTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findMapByType",
      requestType = com.univer.base.grpc.account.AccountRequest.class,
      responseType = com.univer.base.grpc.account.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getFindMapByTypeMethod() {
    io.grpc.MethodDescriptor<AccountRequest, AccountResponse> getFindMapByTypeMethod;
    if ((getFindMapByTypeMethod = AccountServiceGrpc.getFindMapByTypeMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getFindMapByTypeMethod = AccountServiceGrpc.getFindMapByTypeMethod) == null) {
          AccountServiceGrpc.getFindMapByTypeMethod = getFindMapByTypeMethod =
              io.grpc.MethodDescriptor.<com.univer.base.grpc.account.AccountRequest, com.univer.base.grpc.account.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "account.AccountService", "findMapByType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("findMapByType"))
                  .build();
          }
        }
     }
     return getFindMapByTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getFindNameByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findNameByUserId",
      requestType = com.univer.base.grpc.account.AccountRequest.class,
      responseType = com.univer.base.grpc.account.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AccountRequest,
      AccountResponse> getFindNameByUserIdMethod() {
    io.grpc.MethodDescriptor<AccountRequest, AccountResponse> getFindNameByUserIdMethod;
    if ((getFindNameByUserIdMethod = AccountServiceGrpc.getFindNameByUserIdMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getFindNameByUserIdMethod = AccountServiceGrpc.getFindNameByUserIdMethod) == null) {
          AccountServiceGrpc.getFindNameByUserIdMethod = getFindNameByUserIdMethod =
              io.grpc.MethodDescriptor.<com.univer.base.grpc.account.AccountRequest, com.univer.base.grpc.account.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "account.AccountService", "findNameByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.univer.base.grpc.account.AccountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("findNameByUserId"))
                  .build();
          }
        }
     }
     return getFindNameByUserIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountServiceStub newStub(io.grpc.Channel channel) {
    return new AccountServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccountServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccountServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AccountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void detail(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDetailMethod(), responseObserver);
    }

    /**
     */
    public void listByIds(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListByIdsMethod(), responseObserver);
    }

    /**
     */
    public void findDictByType(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindDictByTypeMethod(), responseObserver);
    }

    /**
     */
    public void findMapByType(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindMapByTypeMethod(), responseObserver);
    }

    /**
     */
    public void findNameByUserId(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindNameByUserIdMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDetailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.univer.base.grpc.account.AccountRequest,
                com.univer.base.grpc.account.AccountResponse>(
                  this, METHODID_DETAIL)))
          .addMethod(
            getListByIdsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.univer.base.grpc.account.AccountRequest,
                com.univer.base.grpc.account.AccountResponse>(
                  this, METHODID_LIST_BY_IDS)))
          .addMethod(
            getFindDictByTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.univer.base.grpc.account.AccountRequest,
                com.univer.base.grpc.account.AccountResponse>(
                  this, METHODID_FIND_DICT_BY_TYPE)))
          .addMethod(
            getFindMapByTypeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.univer.base.grpc.account.AccountRequest,
                com.univer.base.grpc.account.AccountResponse>(
                  this, METHODID_FIND_MAP_BY_TYPE)))
          .addMethod(
            getFindNameByUserIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.univer.base.grpc.account.AccountRequest,
                com.univer.base.grpc.account.AccountResponse>(
                  this, METHODID_FIND_NAME_BY_USER_ID)))
          .build();
    }
  }

  /**
   */
  public static final class AccountServiceStub extends io.grpc.stub.AbstractStub<AccountServiceStub> {
    private AccountServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AccountServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void detail(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDetailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listByIds(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListByIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findDictByType(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindDictByTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findMapByType(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindMapByTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findNameByUserId(com.univer.base.grpc.account.AccountRequest request,
        io.grpc.stub.StreamObserver<AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindNameByUserIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AccountServiceBlockingStub extends io.grpc.stub.AbstractStub<AccountServiceBlockingStub> {
    private AccountServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AccountServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.univer.base.grpc.account.AccountResponse detail(com.univer.base.grpc.account.AccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getDetailMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.univer.base.grpc.account.AccountResponse listByIds(com.univer.base.grpc.account.AccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getListByIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.univer.base.grpc.account.AccountResponse findDictByType(com.univer.base.grpc.account.AccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindDictByTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.univer.base.grpc.account.AccountResponse findMapByType(com.univer.base.grpc.account.AccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindMapByTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.univer.base.grpc.account.AccountResponse findNameByUserId(com.univer.base.grpc.account.AccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindNameByUserIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AccountServiceFutureStub extends io.grpc.stub.AbstractStub<AccountServiceFutureStub> {
    private AccountServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AccountServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AccountResponse> detail(
        com.univer.base.grpc.account.AccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDetailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AccountResponse> listByIds(
        com.univer.base.grpc.account.AccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListByIdsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AccountResponse> findDictByType(
        com.univer.base.grpc.account.AccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindDictByTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AccountResponse> findMapByType(
        com.univer.base.grpc.account.AccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindMapByTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AccountResponse> findNameByUserId(
        com.univer.base.grpc.account.AccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindNameByUserIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DETAIL = 0;
  private static final int METHODID_LIST_BY_IDS = 1;
  private static final int METHODID_FIND_DICT_BY_TYPE = 2;
  private static final int METHODID_FIND_MAP_BY_TYPE = 3;
  private static final int METHODID_FIND_NAME_BY_USER_ID = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DETAIL:
          serviceImpl.detail((com.univer.base.grpc.account.AccountRequest) request,
              (io.grpc.stub.StreamObserver<AccountResponse>) responseObserver);
          break;
        case METHODID_LIST_BY_IDS:
          serviceImpl.listByIds((com.univer.base.grpc.account.AccountRequest) request,
              (io.grpc.stub.StreamObserver<AccountResponse>) responseObserver);
          break;
        case METHODID_FIND_DICT_BY_TYPE:
          serviceImpl.findDictByType((com.univer.base.grpc.account.AccountRequest) request,
              (io.grpc.stub.StreamObserver<AccountResponse>) responseObserver);
          break;
        case METHODID_FIND_MAP_BY_TYPE:
          serviceImpl.findMapByType((com.univer.base.grpc.account.AccountRequest) request,
              (io.grpc.stub.StreamObserver<AccountResponse>) responseObserver);
          break;
        case METHODID_FIND_NAME_BY_USER_ID:
          serviceImpl.findNameByUserId((com.univer.base.grpc.account.AccountRequest) request,
              (io.grpc.stub.StreamObserver<AccountResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.univer.base.grpc.account.Account.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountService");
    }
  }

  private static final class AccountServiceFileDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier {
    AccountServiceFileDescriptorSupplier() {}
  }

  private static final class AccountServiceMethodDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccountServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountServiceFileDescriptorSupplier())
              .addMethod(getDetailMethod())
              .addMethod(getListByIdsMethod())
              .addMethod(getFindDictByTypeMethod())
              .addMethod(getFindMapByTypeMethod())
              .addMethod(getFindNameByUserIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
