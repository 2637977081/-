package com.univer.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.account.service.UserService;
import com.univer.account.vo.UserVo;
import com.univer.base.bo.UserBo;
import com.univer.base.util.JwtUtil;
import com.univer.base.vo.ResultVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.mockito.Mockito.*;

public class AccountControllerTest {
    @Mock
    Logger logger;
    @Mock
    MessageSource messageSource;
    @Mock
    JwtUtil<UserBo> jwtUtil;
    @Mock
    StringRedisTemplate template;
    @Mock
    UserVo userVo;
    @Mock
    UserService userService;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    ResultVo<Object> resultVo;
    @InjectMocks
    AccountController accountController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() throws Exception {
        when(jwtUtil.createJWT(anyString(), anyString())).thenReturn("createJWTResponse");
        when(jwtUtil.getTtlMillis()).thenReturn(0L);
        when(userVo.getCommonName()).thenReturn("getCommonNameResponse");
        when(userVo.getRandom()).thenReturn("getRandomResponse");
        when(userVo.getCaptcha()).thenReturn("getCaptchaResponse");
        when(userVo.getUserId()).thenReturn(Long.valueOf(1));
        when(userVo.getCode()).thenReturn("getCodeResponse");
        when(userVo.getUsername()).thenReturn("getUsernameResponse");
        when(userVo.getName()).thenReturn("getNameResponse");
        when(userVo.getEmail()).thenReturn("getEmailResponse");
        when(userVo.getPhone()).thenReturn("getPhoneResponse");
        when(userVo.getPassword()).thenReturn("getPasswordResponse");
        when(userVo.getCaptchaStatus()).thenReturn(Boolean.TRUE);
        when(userVo.getStatus()).thenReturn("getStatusResponse");
        UserVo persist = new UserVo();
        persist.setCaptchaStatus(true);

        when(userService.findUser(anyString())).thenReturn(persist);
        when(userService.updateCaptchaStatus(any())).thenReturn(Boolean.TRUE);
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ValueOperations valueOperations = Mockito.mock(ValueOperations.class);
        when(template.opsForValue()).thenReturn(valueOperations);

        UserVo temp = new UserVo();
        temp.setCommonName("guwei");
        temp.setPassword("123456789");
        temp.setRandom("0000000000");
        temp.setCaptcha("aaaa");
        //停留在template CaptchaUtil.getCaptcha 空指针异常
        ResultVo result = accountController.login(temp);
        Assert.assertNotNull(result);
    }

    @Test
    public void testLogout() throws Exception {
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = accountController.logout("code");
        Assert.assertNotNull(result);
    }

    @Test
    public void testExist() throws Exception {
        when(userService.findUser(anyLong(), anyString())).thenReturn(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = accountController.exist(Long.valueOf(1), "commonName");
        Assert.assertNotNull(result);
    }

//    @Test
//    public void testEmailCaptcha() throws Exception {
//        when(userService.findUser(any())).thenReturn(new UserVo(Long.valueOf(1), "code", "username", "nickname", "phone", "email"));
//        when(userVo.getRandom()).thenReturn("getRandomResponse");
//        when(userVo.getEmail()).thenReturn("getEmailResponse");
//        when(emailFeign.emailCaptcha(any())).thenReturn(new ResultVo());
//        ValueOperations valueOperations = Mockito.mock(ValueOperations.class);
//        when(template.opsForValue()).thenReturn(valueOperations);
//
//        ResultVo result = accountController.emailCaptcha(new UserVo(Long.valueOf(1), "code", "username", "nickname", "phone", "email"));
//        Assert.assertNotNull(result);
//    }

    @Test
    public void testEmailCaptchaValid() throws Exception {
        when(jwtUtil.createJWT(anyString(), anyString())).thenReturn("createJWTResponse");
        when(jwtUtil.getTtlMillis()).thenReturn(0L);
        when(userVo.getRandom()).thenReturn("getRandomResponse");
        when(userVo.getCaptcha()).thenReturn("getCaptchaResponse");
        when(userVo.getUserId()).thenReturn(Long.valueOf(1));
        when(userVo.getCode()).thenReturn("getCodeResponse");
        when(userVo.getUsername()).thenReturn("getUsernameResponse");
        when(userVo.getName()).thenReturn("getNameResponse");
        when(userVo.getEmail()).thenReturn("getEmailResponse");
        when(userVo.getPhone()).thenReturn("getPhoneResponse");
        when(userService.findUser(anyString())).thenReturn(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());
        ValueOperations valueOperations = Mockito.mock(ValueOperations.class);
        when(template.opsForValue()).thenReturn(valueOperations);
        ResultVo result = accountController.emailCaptchaValid(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testPhoneCaptcha() throws Exception {
        when(userVo.getRandom()).thenReturn("getRandomResponse");
        ValueOperations valueOperations = Mockito.mock(ValueOperations.class);
        when(template.opsForValue()).thenReturn(valueOperations);
        ResultVo result = accountController.phoneCaptcha(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme