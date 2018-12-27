package com.univer.account.service;

import com.univer.account.mapper.RoleMapper;
import com.univer.account.po.Func;
import com.univer.account.po.Role;
import com.univer.account.vo.RoleVo;
import com.univer.base.mapper.BaseMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class RoleServiceTest {
    @Mock
    Logger log;
    @Mock
    RoleMapper roleMapper;
    @Mock
    FuncRoleService funcRoleService;
    @Mock
    FuncService funcService;
    @Mock
    MessageSource messageSource;
    @Mock
    BaseMapper<Object> mapper;
    //Field modelClass of type Class - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    RoleService roleService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByPage() throws Exception {
        RoleVo roleVo = new RoleVo();
        roleVo.setName("name");
        roleVo.setStatus("status");
        when(roleMapper.findRoleList(anyString(), anyString())).thenReturn(Arrays.<RoleVo>asList(new RoleVo()));

        List<RoleVo> result = roleService.findByPage(roleVo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindRoleById() throws Exception {
        when(funcService.findByRoleId(anyLong(), anyString())).thenReturn(Arrays.<Func>asList(new Func()));
        Role role = new Role();
        role.setCode("0000");
        when(roleMapper.selectByPrimaryKey(anyLong())).thenReturn(role);
        RoleVo result = roleService.findRoleById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindRoleByUserId() throws Exception {
        List<RoleVo> list = new ArrayList<>();
        RoleVo roleVo = new RoleVo();
        roleVo.setStatus("status");
        list.add(roleVo);
        when(roleMapper.getRoleByUserId(anyLong(), anyString())).thenReturn(list);

        List<RoleVo> result = roleService.findRoleByUserId(Long.valueOf(1), "status");
        Assert.assertNotNull(result);
    }

    @Test
    public void testSaveRole() throws Exception {
        RoleVo roleVo = new RoleVo();
        roleVo.setStatus("status");
        when(roleService.findRoleById(any())).thenReturn(roleVo);
        RoleVo result = roleService.saveRole(new RoleVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateRole() throws Exception {
        RoleVo roleVo = new RoleVo();
        roleVo.setStatus("status");
        when(funcService.findByRoleId(anyLong(), anyString())).thenReturn(Arrays.<Func>asList(new Func()));
        when(roleService.findRoleById(any())).thenReturn(roleVo);
        RoleVo result = roleService.updateRole(new RoleVo());
        Assert.assertNotNull(result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme