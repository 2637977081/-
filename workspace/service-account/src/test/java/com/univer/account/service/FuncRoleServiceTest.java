package com.univer.account.service;

import com.univer.account.mapper.FuncRoleMapper;
import com.univer.account.po.Func;
import com.univer.account.po.FuncRole;
import com.univer.account.vo.FuncRoleVo;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class FuncRoleServiceTest {
    @Mock
    Logger log;
    @Mock
    FuncRoleMapper funcRoleMapper;
    @Mock
    MessageSource messageSource;
    @Mock
    BaseMapper<Object> mapper;
    @Mock
    FuncRole funcRole;
    //Field modelClass of type Class - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    FuncRoleService funcRoleService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByPage() throws Exception {
        FuncRoleVo funcRoleVo = new FuncRoleVo();
        funcRoleVo.setRoleId(Long.valueOf(1));
        funcRoleVo.setFuncId(Long.valueOf(1));
        List<FuncRoleVo> result = funcRoleService.findByPage(funcRoleVo);
        Assert.assertNull(result);
    }

    @Test
    public void testFindFuncRoleById() throws Exception {
        FuncRoleVo frv = new FuncRoleVo();
        frv.setFuncRoleId(Long.valueOf(1));
        FuncRole fr = new FuncRole();
        fr.setFuncRoleId(Long.valueOf(1));

        when(funcRoleMapper.selectByPrimaryKey(Long.valueOf(1))).thenReturn(fr);

        FuncRoleVo result = funcRoleService.findFuncRoleById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testSaveFuncRole() throws Exception {
        FuncRoleVo frv = new FuncRoleVo();
        frv.setFuncRoleId(Long.valueOf(1));
        FuncRole fr = new FuncRole();
        fr.setFuncRoleId(Long.valueOf(1));

        when(funcRoleMapper.insertSelective(any())).thenReturn(1);
        when(funcRole.getFuncRoleId()).thenReturn(Long.valueOf(1));
        when(funcRoleService.findFuncRoleById(Long.valueOf(1))).thenReturn(frv);

        FuncRoleVo result = funcRoleService.saveFuncRole(frv);
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateFuncRole() throws Exception {
        FuncRoleVo frv = new FuncRoleVo();
        frv.setFuncRoleId(Long.valueOf(1));
        FuncRole fr = new FuncRole();
        fr.setFuncRoleId(Long.valueOf(1));

        when(funcRoleMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        when(funcRole.getFuncRoleId()).thenReturn(Long.valueOf(1));
        when(funcRoleService.findFuncRoleById(Long.valueOf(1))).thenReturn(frv);

        FuncRoleVo result = funcRoleService.updateFuncRole(frv);
        Assert.assertNotNull(result);
    }

    @Test
    public void testSave() throws Exception {
        int result = funcRoleService.save(new FuncRole(Long.valueOf(1), Long.valueOf(1), "status"));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testSave2() throws Exception {
        int result = funcRoleService.save(Arrays.<FuncRole>asList(new FuncRole(Long.valueOf(1), Long.valueOf(1), "status")));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testDeleteById() throws Exception {
        int result = funcRoleService.deleteById(Long.valueOf(1));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testDeleteByIds() throws Exception {
        int result = funcRoleService.deleteByIds("ids");
        Assert.assertEquals(0, result);
    }

    @Test
    public void testUpdate() throws Exception {
        int result = funcRoleService.update(new FuncRole(Long.valueOf(1), Long.valueOf(1), "status"));
        Assert.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme