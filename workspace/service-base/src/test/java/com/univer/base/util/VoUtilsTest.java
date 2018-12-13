package com.univer.base.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: lvgang
 * @date: 2018-10-12 11:45
 **/
public class VoUtilsTest {

    @Test
    public void testCopyProperties() throws Exception {
        VoUtils.copyProperties("source", "target", "properties");
    }

    @Test
    public void testGetField() throws Exception {
        Field result = VoUtils.getField(Class.forName("com.univer.base.util.VoUtils"), "property");
        Assert.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme