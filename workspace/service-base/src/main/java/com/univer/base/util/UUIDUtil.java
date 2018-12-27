package com.univer.base.util;

import java.util.UUID;

/**
 * @author guwei
 */
public class UUIDUtil {

    /**
     * 生成32位UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
