package com.univer.base.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @author: lvgang
 * @date: 2018-10-12 11:45
 **/
public class UUIDUtilTest {

    @Test
    public void testGetUUID() throws Exception {
        String result = UUIDUtil.getUUID();
        Assert.assertEquals(32, result.length());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme