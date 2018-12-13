package com.univer.account.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.account.po.Dict;
import com.univer.account.po.User;
import com.univer.account.vo.UserVo;
import com.univer.base.grpc.account.AccountRequest;
import com.univer.base.grpc.account.AccountResponse;
import com.univer.base.grpc.account.AccountServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author lvgang
 * @descript
 * @time 2018-11-28 17:49
 */
@GRpcService
public class AccountGrpcService extends AccountServiceGrpc.AccountServiceImplBase {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private DictService dictService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void detail(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        try{
            String requestValue = request.getJson();
            Long id = Long.valueOf(requestValue);
            UserVo userVo = userService.findUserById(id);
            String value = objectMapper.writeValueAsString(userVo);
            AccountResponse.Builder builder = AccountResponse.newBuilder().setJson(value);
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }catch (Exception e){
            Throwable throwable = e.getCause();
            logger.error("save service-account Service Down. Reason: {}, request Content: {}",throwable.getMessage(),request);
        }
    }

    @Override
    public void listByIds(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        try{
            List<User> list = userService.findByIds(request.getJson());
            String value = objectMapper.writeValueAsString(list);
            AccountResponse.Builder builder = AccountResponse.newBuilder().setJson(value);
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }catch (Exception e){
            Throwable throwable = e.getCause();
            logger.error("save service-account Service Down. Reason: {}, request Content: {}",throwable.getMessage(),request);
        }
    }

    @Override
    public void findDictByType(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        try{
            List<Dict> list = dictService.findDictByType(request.getJson());
            String value = objectMapper.writeValueAsString(list);
            AccountResponse.Builder builder = AccountResponse.newBuilder().setJson(value);
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }catch (Exception e){
            Throwable throwable = e.getCause();
            logger.error("save service-account Service Down. Reason: {}, request Content: {}",throwable.getMessage(),request);
        }
    }

    @Override
    public void findMapByType(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        try{
            Map<String,String> map = dictService.findMapByType(request.getJson());
            String value = objectMapper.writeValueAsString(map);
            AccountResponse.Builder builder = AccountResponse.newBuilder().setJson(value);
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }catch (Exception e){
            Throwable throwable = e.getCause();
            logger.error("save service-account Service Down. Reason: {}, request Content: {}",throwable.getMessage(),request);
        }
    }

    @Override
    public void findNameByUserId(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        Long userId =Long.parseLong(request.getJson());
        User user = userService.findById(userId);
        String username = user.getUsername();
        AccountResponse.Builder builder = AccountResponse.newBuilder().setJson(username);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
