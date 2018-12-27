package com.univer.base.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @author: lvgang
 * @date: 2018-10-12 11:44
 **/
public class PatternUtilTest {

    @Test
    public void testMatchUsername() throws Exception {
        boolean result = PatternUtil.matchUsername("username");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMatchEmail() throws Exception {
        boolean result = PatternUtil.matchEmail("lvgang@univer.ai");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMatchPhone() throws Exception {
        boolean result = PatternUtil.matchPhone("12345678910");
        Assert.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme