package com.univer.account.service;

import com.univer.account.mapper.UserMapper;
import com.univer.account.po.Org;
import com.univer.account.po.User;
import com.univer.account.vo.*;
import com.univer.base.mapper.BaseMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Mock
    Logger log;
    @Mock
    OrgService orgService;
    @Mock
    RoleService roleService;
    @Mock
    FuncService funcService;
    @Mock
    Org org;
    @Mock
    UserRoleService userRoleService;
    @Mock
    UserMapper userMapper;
    @Mock
    MessageSource messageSource;
    @Mock
    BaseMapper<Object> mapper;
    //Field modelClass of type Class - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByPage() throws Exception {
        when(userMapper.selectUserVoByCondition(any())).thenReturn(Arrays.<UserVo>asList(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email")));

        List<UserVo> result = userService.findByPage(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindUserById() throws Exception {
        OrgVo orgVo = new OrgVo();
        orgVo.setName("name");
        Org o = new Org();
        o.setName("name");
        when(org.getName()).thenReturn("name");
        when(orgService.findOrgById(any())).thenReturn(orgVo);
        when(roleService.findRoleByUserId(anyLong(), anyString())).thenReturn(Arrays.<RoleVo>asList(new RoleVo()));
        when(funcService.getFuncVoByUserId(anyLong(), anyString())).thenReturn(Arrays.<FuncVo>asList(new FuncVo()));
        when(funcService.getFuncTreeByUserId(anyLong(), anyString())).thenReturn(new FuncTreeVo());
        User user = new User();
        user.setCode("0000");
        when(userMapper.selectByPrimaryKey(any())).thenReturn(user);

        UserVo result = userService.findUserById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindUser() throws Exception {
        OrgVo orgVo = new OrgVo();
        orgVo.setName("name");
        when(orgService.findOrgById(any())).thenReturn(orgVo);
        when(roleService.findRoleByUserId(anyLong(), anyString())).thenReturn(Arrays.<RoleVo>asList(new RoleVo()));
        when(funcService.getFuncVoByUserId(anyLong(), anyString())).thenReturn(Arrays.<FuncVo>asList(new FuncVo()));
        when(funcService.getFuncTreeByUserId(anyLong(), anyString())).thenReturn(new FuncTreeVo());
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setCode("000");
        list.add(user);
        when(userMapper.selectByCondition(any())).thenReturn(list);
        UserVo result = userService.findUser("commonName");
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindUser2() throws Exception {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setCode("000");
        list.add(user);
        when(userMapper.selectByCondition(any())).thenReturn(list);
        UserVo result = userService.findUser(Long.valueOf(1), "commonName");
        Assert.assertNotNull(result);
    }

    @Test
    public void testSaveUser() throws Exception {
        OrgVo orgVo = new OrgVo();
        orgVo.setName("name");
        when(userMapper.insertSelective(any())).thenReturn(1);
        when(orgService.findOrgById(any())).thenReturn(orgVo);
        UserVo userVo = new UserVo();
        userVo.setUserId(Long.valueOf(1));
        when(userService.findUserById(any())).thenReturn(userVo);
        UserVo result = userService.saveUser(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateUser() throws Exception {
        OrgVo orgVo = new OrgVo();
        orgVo.setName("name");
        when(orgService.findOrgById(any())).thenReturn(orgVo);
        when(userMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        UserVo userVo = new UserVo();
        userVo.setUserId(Long.valueOf(1));
        when(userService.findUserById(any())).thenReturn(userVo);
        UserVo result = userService.updateUser(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdatePassword() throws Exception {
        when(userMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        Boolean result = userService.updatePassword(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testUpdateCaptchaStatus() throws Exception {
        when(userMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        Boolean result = userService.updateCaptchaStatus(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testUpdateResetStatus() throws Exception {
        when(userMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        Boolean result = userService.updateResetStatus(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testFindUserByOrgId() throws Exception {
        when(userMapper.selectUserVoByOrgId(any())).thenReturn(Arrays.<UserVo>asList(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email")));

        List<UserVo> result = userService.findUserByOrgId(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertNotNull(result);
    }

    @Test
    public void testIsExistedUser() throws Exception {
        when(userMapper.selectCountByCondition(any())).thenReturn(1);
        Boolean result = userService.isExistedUser(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));
        Assert.assertEquals(Boolean.TRUE, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme