package com.univer.account.service;

import com.univer.account.mapper.FuncMapper;
import com.univer.account.mapper.RoleMapper;
import com.univer.account.po.Func;
import com.univer.account.vo.FuncTreeVo;
import com.univer.account.vo.FuncVo;
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
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FuncServiceTest {
    @Mock
    Logger log;
    @Mock
    FuncMapper funcMapper;
    @Mock
    RoleMapper roleMapper;
    @Mock
    MessageSource messageSource;
    @Mock
    BaseMapper<Object> mapper;
    //Field modelClass of type Class - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    FuncService funcService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByPage() throws Exception {
        List<FuncVo> result = funcService.findByPage(new FuncVo());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetFuncByUserId() throws Exception {
        List<Func> list = new ArrayList<>();
        Func func = new Func();
        func.setCode("0000");
        list.add(func);
        when(funcMapper.getFuncByUserId(anyLong(), anyString())).thenReturn(list);

        List<Func> result = funcService.getFuncByUserId(Long.valueOf(1), "status");
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetFuncVoByUserId() throws Exception {
        List<FuncVo> list = new ArrayList<>();
        FuncVo funcVo = new FuncVo();
        funcVo.setCode("0000");
        list.add(funcVo);
        when(funcMapper.getFuncVoByUserId(anyLong(), anyString())).thenReturn(list);
        when(roleMapper.countByCodeAndUserId(anyString(), anyLong())).thenReturn(Integer.valueOf(0));

        List<FuncVo> result = funcService.getFuncVoByUserId(Long.valueOf(1), "status");
        Assert.assertNotNull(result);
    }
//
//    @Test
//    public void testGetFuncTreeByUserId() throws Exception {
//        List<Func> list = new ArrayList<>();
//        Func func = new Func();
//        func.setCode("0000");
//        list.add(func);
//        when(funcMapper.getFuncByUserId(anyLong(), anyString())).thenReturn(list);
//        when(roleMapper.countByCodeAndUserId(anyString(), anyLong())).thenReturn(Integer.valueOf(0));
//        when(roleMapper.countByCodeAndUserId(anyString(),anyLong())).thenReturn(1);
//        FuncTreeVo funcTreeVo = new FuncTreeVo();
//        funcTreeVo.setFunc(func);
//        when(funcService.getFuncTree(any())).thenReturn(funcTreeVo);
//        FuncTreeVo result = funcService.getFuncTreeByUserId(Long.valueOf(1), "status");
//        Assert.assertNotNull(result);
//    }

    @Test
    public void testFindByRoleId() throws Exception {
        List<Func> list = new ArrayList<>();
        Func func = new Func();
        func.setCode("0000");
        list.add(func);
        when(funcMapper.selectByRoleId(anyLong(), anyString())).thenReturn(list);

        List<Func> result = funcService.findByRoleId(Long.valueOf(1), "status");
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetFuncTreeById() throws Exception {
        Func f = new Func();
        f.setCode("0000");
        when(funcMapper.selectByPrimaryKey(Long.valueOf(1))).thenReturn(f);
        FuncTreeVo result = funcService.getFuncTreeById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindFuncById() throws Exception {
        Func f = new Func();
        f.setCode("0000");
        when(funcMapper.selectByPrimaryKey(Long.valueOf(1))).thenReturn(f);
        FuncVo result = funcService.findFuncById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindAllByRootId() throws Exception {
        List<Func> result = funcService.findAllByRootId(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testIsExistedFunc() throws Exception {
        Func func = new Func();
        func.setCode("0000");
        when(funcMapper.selectByPrimaryKey(anyLong())).thenReturn(func);
        boolean result = funcService.isExistedFunc(Long.valueOf(1));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testSaveFunc() throws Exception {
        Func func = new Func();
        func.setFuncId(Long.valueOf(1));
        FuncVo funcVo = new FuncVo();
        funcVo.setFuncId(Long.valueOf(1));

        when(funcMapper.selectMaxNumber(anyLong())).thenReturn(Long.valueOf(1));
        when(funcMapper.insertSelective(any())).thenReturn(1);
        when(funcService.findFuncById(anyLong())).thenReturn(funcVo);
        FuncVo result = funcService.saveFunc(funcVo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateFunc() throws Exception {
        Func func = new Func();
        func.setFuncId(Long.valueOf(1));
        FuncVo funcVo = new FuncVo();
        funcVo.setFuncId(Long.valueOf(1));

        when(funcMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        when(funcService.findFuncById(any())).thenReturn(funcVo);

        FuncVo result = funcService.updateFunc(new FuncVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testDeleteFuncById() throws Exception {
        Func func = new Func();
        func.setFuncId(Long.valueOf(1));
        FuncVo funcVo = new FuncVo();
        funcVo.setFuncId(Long.valueOf(1));

        when(funcMapper.selectByPrimaryKey(anyLong())).thenReturn(func);
        when(funcMapper.selectCountByCondition(anyLong())).thenReturn(1);
        String result = funcService.deleteFuncById(Long.valueOf(0));
        Assert.assertEquals("200", result);
    }

    @Test
    public void testGetFuncTree() throws Exception {
        List<Func> list = new ArrayList<>();
        Func func = new Func();
        func.setFuncId(Long.valueOf(2));
        func.setParentId(Long.valueOf(1));
        list.add(func);

        when(funcMapper.selectByCondition(any())).thenReturn(list);
        FuncTreeVo result = funcService.getFuncTree(list);
        Assert.assertNotNull(result);
    }

    @Test
    public void testSave() throws Exception {
        int result = funcService.save(new Func());
        Assert.assertEquals(0, result);
    }

    @Test
    public void testSave2() throws Exception {
        int result = funcService.save(Arrays.<Func>asList(new Func()));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testDeleteById() throws Exception {
        int result = funcService.deleteById(Long.valueOf(1));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testDeleteByIds() throws Exception {
        int result = funcService.deleteByIds("ids");
        Assert.assertEquals(0, result);
    }

    @Test
    public void testUpdate() throws Exception {
        int result = funcService.update(new Func());
        Assert.assertEquals(0, result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme