package com.univer.message.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.base.grpc.message.MessageRequest;
import com.univer.base.grpc.message.MessageResponse;
import com.univer.base.grpc.message.MessageServiceGrpc;
import com.univer.message.po.Email;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author lvgang
 */
@GRpcService
public class EmailGrpcService extends MessageServiceGrpc.MessageServiceImplBase {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void captcha(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        try{
            String requestValue = request.getJsonData();
            Email email = objectMapper.readValue(requestValue,Email.class);
            boolean bool = false;
            if("captcha".equals(email.getType())){
                bool=emailService.sendCaptcha(email);
            }else if("message".equals(email.getType())){
                bool=emailService.sendMessage(email);
            }
            String value = objectMapper.writeValueAsString(bool);
            MessageResponse.Builder builder = MessageResponse.newBuilder().setJsonData(value);
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }catch (Exception e){
            Throwable throwable = e.getCause();
            logger.error("save service-account Service Down. Reason: {}, request Content: {}",throwable.getMessage(),request);
        }

    }
}
