package com.univer.base.grpc.message;

import com.univer.base.constant.ServiceConstant;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author lichunpeng
 */
public class SingletonMessageChannel {
    private static ManagedChannel channel;

    private SingletonMessageChannel() {
    }

    /**
     * 获得ManagedChannel
     */
    public static ManagedChannel getManagedChannel() {
        if (channel == null) {
            channel = ManagedChannelBuilder.forAddress(ServiceConstant.SERVICE_MESSAGE, ServiceConstant.SERVICE_MESSAGE_GRPC_PORT).usePlaintext().build();
        }
        return channel;
    }
}
