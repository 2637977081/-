package com.univer.base.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

/**
 * @description:
 * @author: lvgang
 * @date: 2018-10-12 11:43
 **/
public class CaptchaUtilTest {
    @Mock
    Logger log;
    @InjectMocks
    CaptchaUtil captchaUtil;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateImage() throws Exception {
        byte[] result = CaptchaUtil.createImage("aaab");
        Assert.assertNotEquals(new byte[]{(byte) 0}, result);
    }

}
