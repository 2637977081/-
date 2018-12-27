package com.univer.account.service;

import com.univer.account.mapper.UserRoleMapper;
import com.univer.account.po.UserRole;
import com.univer.account.vo.UserRoleVo;
import com.univer.base.mapper.BaseMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserRoleServiceTest {
    @Mock
    Logger log;
    @Mock
    UserRoleMapper userRoleMapper;
    @Mock
    MessageSource messageSource;
    @Mock
    BaseMapper<Object> mapper;
    //Field modelClass of type Class - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    UserRoleService userRoleService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByPage() throws Exception {
        UserRoleVo userRoleVo = new UserRoleVo();
        userRoleVo.setRoleId(Long.valueOf(1));
        userRoleVo.setPage(1);
        userRoleVo.setRows(1);
        List<UserRoleVo> result = userRoleService.findByPage(userRoleVo);
        Assert.assertNull(result);
    }

    @Test
    public void testFindUserRoleById() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setStatus("status");
        when(userRoleMapper.selectByPrimaryKey(anyLong())).thenReturn(userRole);
        UserRoleVo result = userRoleService.findUserRoleById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testSaveUserRole() throws Exception {
        when(userRoleMapper.insertSelective(any())).thenReturn(1);
        UserRoleVo userRoleVo = new UserRoleVo();
        userRoleVo.setRoleId(Long.valueOf(1));
        when(userRoleService.findUserRoleById(any())).thenReturn(userRoleVo);
        UserRoleVo result = userRoleService.saveUserRole(userRoleVo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateUserRole() throws Exception {
        UserRoleVo userRoleVo = new UserRoleVo();
        userRoleVo.setRoleId(Long.valueOf(1));
        when(userRoleMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        when(userRoleService.findUserRoleById(any())).thenReturn(userRoleVo);
        UserRoleVo result = userRoleService.updateUserRole(userRoleVo);
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme