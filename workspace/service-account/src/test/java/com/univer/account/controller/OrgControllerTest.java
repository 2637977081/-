package com.univer.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.account.service.OrgService;
import com.univer.account.vo.OrgTreeVo;
import com.univer.account.vo.OrgVo;
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

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class OrgControllerTest {
    @Mock
    Logger logger;
    @Mock
    OrgService orgService;
    @Mock
    OrgVo orgVo;
    @Mock
    UserBo loginUser;
    @Mock
    StringRedisTemplate template;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    ResultVo<Object> resultVo;
    @InjectMocks
    OrgController orgController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        when(orgService.getOrgTreeById(anyLong())).thenReturn(new OrgTreeVo());
        when(orgService.findOrgById(anyLong())).thenReturn(new OrgVo());
        when(orgVo.getRootId()).thenReturn(Long.valueOf(1));
        when(loginUser.getOrgId()).thenReturn(Long.valueOf(1));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = orgController.list();
        Assert.assertNotNull(result);
    }

    @Test
    public void testDetail() throws Exception {
        when(orgService.findOrgById(anyLong())).thenReturn(new OrgVo());

        ResultVo result = orgController.detail(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testAdd() throws Exception {
        when(orgService.findOrgById(anyLong())).thenReturn(new OrgVo());
        when(orgService.saveOrg(any())).thenReturn(new OrgVo());
        when(orgService.selectByOrg(anyLong(), anyString(), anyLong(), anyString(),anyString())).thenReturn(Arrays.<OrgVo>asList(new OrgVo()));
        when(orgVo.getName()).thenReturn("getNameResponse");
        when(orgVo.getParentId()).thenReturn(Long.valueOf(1));
        when(orgVo.getRootId()).thenReturn(Long.valueOf(1));
        when(loginUser.getUserId()).thenReturn(Long.valueOf(1));
        when(loginUser.getOrgId()).thenReturn(Long.valueOf(1));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = orgController.add(new OrgVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        OrgVo org = new OrgVo();
        org.setRootId(Long.valueOf(1));
        when(orgService.findOrgById(anyLong())).thenReturn(org);
        when(orgService.updateOrg(any())).thenReturn(new OrgVo());
        when(orgVo.getOrgId()).thenReturn(Long.valueOf(1));
        when(orgVo.getParentId()).thenReturn(Long.valueOf(1));
        when(orgVo.getStatus()).thenReturn("getStatusResponse");
        when(orgVo.getRootId()).thenReturn(Long.valueOf(1));
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = orgController.update(new OrgVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete() throws Exception {
        when(orgService.deleteOrgById(anyLong())).thenReturn("deleteOrgByIdResponse");
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = orgController.delete(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete2() throws Exception {
        when(orgService.deleteByIds(anyString())).thenReturn(0);
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = orgController.delete("ids");
        Assert.assertNotNull(result);
    }

    @Test
    public void testExchange() throws Exception {
        when(orgService.exchangeOrg(anyLong(), anyLong())).thenReturn("exchangeOrgResponse");
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = orgController.exchange(Long.valueOf(1), Long.valueOf(1));
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme