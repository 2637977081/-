package com.univer.base.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;


import static org.mockito.Mockito.*;

public class JwtUtilTest {
    @Mock
    ObjectMapper objectMapper;
    @InjectMocks
    JwtUtil jwtUtil;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private static final Logger log = LoggerFactory.getLogger(JwtUtilTest.class);

    @Test
    public void testGeneralKey() throws Exception {
        jwtUtil.setSecret("secret");
        SecretKey result = jwtUtil.generalKey();
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testCreateJWT() throws Exception {
        jwtUtil.setSecret("secret");
        jwtUtil.setTtlMillis(500000);
        String result = jwtUtil.createJWT("123", "subject");
        log.info(result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testParseJWT() throws Exception {
        jwtUtil.setSecret("secret");
        String result = jwtUtil.createJWT("123", "subject");
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testGenerateSubject() throws Exception {
//        String result = jwtUtil.generateSubject(new T());
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetT() throws Exception {
//        T result = jwtUtil.getT("authorization", null);
//        Assert.assertEquals(new T(), result);
    }

    @Test
    public void testGenerateSecretKey() throws Exception {
        jwtUtil.setSecret("secret");
        String result = jwtUtil.generateSecretKey();
        log.info(result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void testByteToHexString() throws Exception {
        String result = jwtUtil.byteToHexString(new byte[]{(byte) 0});
        Assert.assertEquals("00", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme