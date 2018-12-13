package com.univer.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.account.service.FuncService;
import com.univer.account.vo.FuncTreeVo;
import com.univer.account.vo.FuncVo;
import com.univer.base.bo.UserBo;
import com.univer.base.vo.ResultVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;

import static org.mockito.Mockito.*;

public class FuncControllerTest {
    @Mock
    Logger logger;
    @Mock
    FuncService funcService;
    @Mock
    FuncVo funcVo;
    @Mock
    UserBo loginUser;
    @Mock
    StringRedisTemplate template;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    ResultVo<Object> resultVo;
    @InjectMocks
    FuncController funcController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        when(funcService.getFuncTreeById(anyLong())).thenReturn(new FuncTreeVo());

        ResultVo result = funcController.list(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testDetail() throws Exception {
        when(funcService.findFuncById(anyLong())).thenReturn(new FuncVo());

        ResultVo result = funcController.detail(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testAdd() throws Exception {
        when(funcService.findFuncById(anyLong())).thenReturn(new FuncVo());
        when(funcService.saveFunc(any())).thenReturn(new FuncVo());
        when(funcVo.getParentId()).thenReturn(Long.valueOf(1));
        when(funcVo.getRootId()).thenReturn(Long.valueOf(1));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = funcController.add(new FuncVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(funcService.isExistedFunc(anyLong())).thenReturn(true);
        when(funcService.updateFunc(any())).thenReturn(new FuncVo());
        when(funcVo.getParentId()).thenReturn(Long.valueOf(1));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = funcController.update(new FuncVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete() throws Exception {
        when(funcService.deleteFuncById(anyLong())).thenReturn("deleteFuncByIdResponse");
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = funcController.delete(Long.valueOf(1));
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme