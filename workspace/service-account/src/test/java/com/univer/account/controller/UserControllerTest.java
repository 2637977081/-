package com.univer.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.account.po.User;
import com.univer.account.service.UserService;
import com.univer.account.vo.UserVo;
import com.univer.base.bo.UserBo;
import com.univer.base.vo.ResultVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class UserControllerTest {
    @Mock
    Logger logger;
    @Mock
    StringRedisTemplate template;
    @Mock
    UserVo userVo;
    @Mock
    UserService userService;
    @Mock
    UserBo loginUser;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    ResultVo<Object> resultVo;
    @InjectMocks
    UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        when(userService.findByPage(any())).thenReturn(Arrays.<UserVo>asList(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email")));

        ResultVo result = userController.list(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testDetail() throws Exception {
        when(userService.findUserById(anyLong())).thenReturn(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));

        ResultVo result = userController.detail(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testAdd() throws Exception {
        when(userVo.getPassword()).thenReturn("getPasswordResponse");
        when(userService.saveUser(any())).thenReturn(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        when(userService.isExistedUser(any())).thenReturn(Boolean.TRUE);
        when(loginUser.getUserId()).thenReturn(Long.valueOf(1));

        ResultVo result = userController.add(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(userVo.getPassword()).thenReturn("getPasswordResponse");
        when(userService.updateUser(any())).thenReturn(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        int bcryptSalt = 4;
        Field field = userController.getClass().getDeclaredField("bcryptSalt");
        field.setAccessible(true);
        field.set(userController,bcryptSalt);
        ResultVo result = userController.update(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdatePassword() throws Exception {
        when(userVo.getRandom()).thenReturn("getRandomResponse");
        when(userVo.getCaptcha()).thenReturn("getCaptchaResponse");
        when(userVo.getNewPassword()).thenReturn("getNewPasswordResponse");
        when(userVo.getConfirmPassword()).thenReturn("getConfirmPasswordResponse");
        when(userVo.getPassword()).thenReturn("getPasswordResponse");
        when(userService.updatePassword(any())).thenReturn(Boolean.TRUE);
        when(loginUser.getUserId()).thenReturn(Long.valueOf(1));
        when(loginUser.getPassword()).thenReturn("getPasswordResponse");
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ValueOperations valueOperations = Mockito.mock(ValueOperations.class);
        when(template.opsForValue()).thenReturn(valueOperations);

        ResultVo result = userController.updatePassword(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete() throws Exception {
        when(userService.deleteById(anyLong())).thenReturn(0);
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = userController.delete(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete2() throws Exception {
        when(userService.deleteByIds(anyString())).thenReturn(0);
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = userController.delete("ids");
        Assert.assertNotNull(result);
    }

    @Test
    public void testListByIds() throws Exception {
        when(userService.findByIds(anyString())).thenReturn(Arrays.<User>asList(new User(Long.valueOf(1), "code", "username", "name", "gender","phone", "email")));

        ResultVo result = userController.listByIds("ids");
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme