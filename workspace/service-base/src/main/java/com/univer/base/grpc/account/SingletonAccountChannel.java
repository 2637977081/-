package com.univer.base.grpc.account;

import com.univer.base.constant.ServiceConstant;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author lichunpeng
 */
public class SingletonAccountChannel {
    private static ManagedChannel channel;

    private SingletonAccountChannel(){
    }

    /**
     * 获得ManagedChannel
     */
    public static ManagedChannel getManagedChannel() {
        if (channel == null) {
            channel = ManagedChannelBuilder.forAddress(ServiceConstant.SERVICE_ACCOUNT, ServiceConstant.SERVICE_ACCOUNT_GRPC_PORT).usePlaintext().build();
        }
        return channel;
    }
}
