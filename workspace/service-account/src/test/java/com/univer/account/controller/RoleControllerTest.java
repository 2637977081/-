package com.univer.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.account.po.UserRole;
import com.univer.account.service.FuncService;
import com.univer.account.service.RoleService;
import com.univer.account.service.UserRoleService;
import com.univer.account.vo.FuncVo;
import com.univer.account.vo.RoleVo;
import com.univer.account.vo.UserVo;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class RoleControllerTest {
    @Mock
    Logger logger;
    @Mock
    RoleVo roleVo;
    @Mock
    RoleService roleService;
    @Mock
    FuncService funcService;
    @Mock
    UserBo loginUser;
    @Mock
    UserRoleService userRoleService;
    @Mock
    StringRedisTemplate template;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    ResultVo<Object> resultVo;
    @InjectMocks
    RoleController roleController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        when(roleService.findByPage(any())).thenReturn(Arrays.<RoleVo>asList(new RoleVo()));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = roleController.list(new RoleVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testFuncRoleList() throws Exception {
        when(roleService.findRoleByUserId(anyLong(), anyString())).thenReturn(Arrays.<RoleVo>asList(new RoleVo()));
        when(funcService.getFuncVoByUserId(anyLong(), anyString())).thenReturn(Arrays.<FuncVo>asList(new FuncVo()));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = roleController.funcRoleList(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testDetail() throws Exception {
        when(roleService.findRoleById(anyLong())).thenReturn(new RoleVo());

        ResultVo result = roleController.detail(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testAdd() throws Exception {
        when(roleService.saveRole(any())).thenReturn(new RoleVo());
        when(loginUser.getUserId()).thenReturn(Long.valueOf(1));

        ResultVo result = roleController.add(new RoleVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(roleVo.getStatus()).thenReturn("getStatusResponse");
        when(roleService.updateRole(any())).thenReturn(new RoleVo());
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = roleController.update(new RoleVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete() throws Exception {
        when(roleService.deleteById(anyLong())).thenReturn(0);
        when(funcService.deleteById(anyLong())).thenReturn(0);
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());
        List<UserRole> list = new ArrayList<>();
        UserRole userRole = new UserRole();
        userRole.setUserId(Long.valueOf(1));
        list.add(userRole);
        when(userRoleService.findUserRole(any(),any())).thenReturn(list);
        ResultVo result = roleController.delete(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete2() throws Exception {
        when(roleService.deleteByIds(anyString())).thenReturn(0);
        when(funcService.deleteByIds(anyString())).thenReturn(0);
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = roleController.delete("ids");
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme