package com.univer.account.service;

import com.univer.account.mapper.OrgMapper;
import com.univer.account.po.Org;
import com.univer.account.po.User;
import com.univer.account.vo.OrgTreeVo;
import com.univer.account.vo.OrgVo;
import com.univer.account.vo.UserVo;
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
public class OrgServiceTest {
    @Mock
    Logger log;
    @Mock
    OrgMapper orgMapper;
    @Mock
    UserService userService;
    @Mock
    OrgTreeVo orgTreeVo;
    @Mock
    Org org;
    @Mock
    MessageSource messageSource;
    @Mock
    BaseMapper<Object> mapper;
    //Field modelClass of type Class - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    OrgService orgService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


//    @Test
//    public void testGetOrgTreeById() throws Exception {
//        List<Org> list = new ArrayList<>();
//        Org o = new Org();
//        o.setRootId(Long.valueOf(1));
//        o.setCode("0000");
//        list.add(o);
//        Org parent = orgTreeVo.getOrg();
//        when(orgMapper.selectByCondition(any())).thenReturn(list);
//        PowerMockito.suppress(PowerMockito.method(OrgService.class,"getChildren",OrgTreeVo.class,List.class));
//        List<OrgTreeVo> list1 = new ArrayList<>();
//        OrgTreeVo otv= new OrgTreeVo();
//        otv.setOrg(o);
//        list1.add(otv);
//        when(orgTreeVo.getChildren()).thenReturn(list1);
//        when(org.getParentId()).thenReturn(Long.valueOf(1));
//        when(org.getOrgId()).thenReturn(Long.valueOf(1));
//
//        OrgTreeVo result = orgService.getOrgTreeById(Long.valueOf(1));
//        Assert.assertNotNull(result);
//    }

    @Test
    public void testGetTopParent() throws Exception {
        Org o = new Org();
        o.setParentId(Long.valueOf(1));
        Org parent = new Org();
        parent.setParentId(Long.valueOf(0));
        when(orgMapper.selectByPrimaryKey(anyLong())).thenReturn(parent);
        Org result = orgService.getTopParent(o);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindAllByRootId() throws Exception {
        List<Org> list = new ArrayList<>();
        Org o = new Org();
        o.setCode("0");
        list.add(o);
        when(orgMapper.selectByCondition(any())).thenReturn(list);
        List<Org> result = orgService.findAllByRootId(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindOrgById() throws Exception {
        Org org = new Org();
        org.setCode("0");
        when(orgMapper.selectByPrimaryKey(anyLong())).thenReturn(org);
        when(userService.findById(anyLong())).thenReturn(new User(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));

        OrgVo result = orgService.findOrgById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetAllParents() throws Exception {
        when(userService.findById(anyLong())).thenReturn(new User(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));

        orgService.getAllParents(new OrgVo());
    }

    @Test
    public void testSaveOrg() throws Exception {
        when(orgMapper.selectMaxNumber(anyLong())).thenReturn(Long.valueOf(1));
        when(orgMapper.insertSelective(any())).thenReturn(1);

        OrgVo orgVo = new OrgVo();
        orgVo.setOrgId(Long.valueOf(1));
        Org org = new Org();
        org.setOrgId(Long.valueOf(1));
        when(orgService.findOrgById(any())).thenReturn(orgVo);
        when(userService.findById(anyLong())).thenReturn(new User(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));

        OrgVo result = orgService.saveOrg(new OrgVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateOrg() throws Exception {
        OrgVo orgVo = new OrgVo();
        orgVo.setOrgId(Long.valueOf(1));
        when(orgMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        when(orgService.findOrgById(any())).thenReturn(orgVo);
        when(userService.findById(anyLong())).thenReturn(new User(Long.valueOf(1), "code", "username", "name", "gender","phone", "email"));

        OrgVo result = orgService.updateOrg(new OrgVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testDeleteOrgById() throws Exception {
        when(userService.findUserByOrgId(any())).thenReturn(Arrays.<UserVo>asList(new UserVo(Long.valueOf(1), "code", "username", "name", "gender","phone", "email")));

        String result = orgService.deleteOrgById(Long.valueOf(1));
        Assert.assertEquals("1010003", result);
    }

    @Test
    public void testExchangeOrg() throws Exception {
        String result = orgService.exchangeOrg(Long.valueOf(1), Long.valueOf(1));
        Assert.assertEquals("1010003", result);
    }

    @Test
    public void testSelectByOrg() throws Exception {
        List<OrgVo> list = new ArrayList<>();
        OrgVo orgVo = new OrgVo();
        orgVo.setOrgId(Long.valueOf(1));
        list.add(orgVo);
        when(orgMapper.selectByMap(any())).thenReturn(list);
        List<OrgVo> result = orgService.selectByOrg(Long.valueOf(1), "name", Long.valueOf(1), "status","likeName");
        Assert.assertNotNull(result);
    }

    @Test
    public void testSave() throws Exception {
        int result = orgService.save(new Org());
        Assert.assertEquals(0, result);
    }

    @Test
    public void testSave2() throws Exception {
        int result = orgService.save(Arrays.<Org>asList(new Org()));
        Assert.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme