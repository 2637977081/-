package com.univer.base.grpc.storage;

import com.univer.base.constant.ServiceConstant;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author lichunpeng
 */
public class SingletonStorageChannel {
    private static ManagedChannel channel;

    private SingletonStorageChannel() {
    }

    /**
     * 获得ManagedChannel
     */
    public static ManagedChannel getManagedChannel() {
        if (channel == null) {
            channel = ManagedChannelBuilder.forAddress(ServiceConstant.SERVICE_STORAGE, ServiceConstant.SERVICE_STORAGE_GRPC_PORT).usePlaintext().build();
        }
        return channel;
    }
}
