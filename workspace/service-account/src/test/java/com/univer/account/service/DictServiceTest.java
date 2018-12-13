package com.univer.account.service;

import com.univer.account.mapper.DictMapper;
import com.univer.account.po.Dict;
import com.univer.account.vo.DictVo;
import com.univer.base.mapper.BaseMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Condition;

import java.util.*;

import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictServiceTest {
    @Mock
    Logger log;
    @Mock
    DictMapper dictMapper;
    @Mock
    MessageSource messageSource;
    @Mock
    BaseMapper<Object> mapper;
    @Mock
    Condition condition;
    @Mock
    Dict dict;
    //Field modelClass of type Class - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    DictService dictService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByPage() throws Exception {
        List<DictVo> result = dictService.findByPage(new DictVo());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFindDictByType() throws Exception {
        //需要添加springrun
        List<Dict> result = dictService.findDictByType("type");
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindMapByType() throws Exception {
        List<DictVo> list = new ArrayList<>();
        DictVo dv1 = new DictVo();
        dv1.setName("k1");
        dv1.setValue("v1");
        list.add(dv1);
        DictVo dv2 = new DictVo();
        dv2.setName("k2");
        dv2.setValue("v2");
        list.add(dv2);

        when(dictMapper.findMapByType(anyString())).thenReturn(list);

        Map<String, String> result = dictService.findMapByType("type");
        HashMap<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        Assert.assertEquals(map, result);
    }

    @Test
    public void testFindDictById() throws Exception {
        DictVo dictVo = new DictVo();
        dictVo.setValue("v");
        when(dictMapper.selectByPrimaryKey(Long.valueOf(1))).thenReturn(dictVo);
        DictVo result = dictService.findDictById(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testSaveDict() throws Exception {
        Dict d = new Dict();
        d.setDictId(Long.valueOf(1));
        DictVo dictVo = new DictVo();
        dictVo.setDictId(Long.valueOf(1));

        when(dictMapper.insertSelective(any())).thenReturn(1);
        when(dict.getDictId()).thenReturn(Long.valueOf(1));
        when(dictService.findDictById(Long.valueOf(1))).thenReturn(dictVo);

        DictVo result = dictService.saveDict(dictVo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateDict() throws Exception {
        when(dictMapper.updateByPrimaryKeySelective(any())).thenReturn(1);
        DictVo dv = new DictVo();
        dv.setDictId(Long.valueOf(1));
        when(dict.getDictId()).thenReturn(Long.valueOf(1));
        when(dictService.findDictById(Long.valueOf(1))).thenReturn(dv);
        DictVo result = dictService.updateDict(dv);
        Assert.assertNotNull(result);
    }

    @Test
    public void testSave() throws Exception {
        int result = dictService.save(new Dict());
        Assert.assertEquals(0, result);
    }

    @Test
    public void testSave2() throws Exception {
        int result = dictService.save(Arrays.<Dict>asList(new Dict()));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testDeleteById() throws Exception {
        int result = dictService.deleteById(Long.valueOf(1));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testDeleteByIds() throws Exception {
        int result = dictService.deleteByIds("ids");
        Assert.assertEquals(0, result);
    }

    @Test
    public void testUpdate() throws Exception {
        int result = dictService.update(new Dict());
        Assert.assertEquals(0, result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme