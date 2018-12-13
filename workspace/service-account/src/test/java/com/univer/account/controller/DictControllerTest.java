package com.univer.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.account.po.Dict;
import com.univer.account.service.DictService;
import com.univer.account.vo.DictVo;
import com.univer.base.vo.ResultVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class DictControllerTest {
    @Mock
    Logger logger;
    @Mock
    DictService dictService;
    @Mock
    ObjectMapper objectMapper;
    @Mock
    ResultVo<Object> resultVo;
    @InjectMocks
    DictController dictController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        when(dictService.findDictByType(anyString())).thenReturn(Arrays.<Dict>asList(new Dict()));

        ResultVo result = dictController.list("type");
        Assert.assertNotNull(result);
    }

    @Test
    public void testMap() throws Exception {
        when(dictService.findMapByType(anyString())).thenReturn(new HashMap<String, String>() {{
            put("String", "String");
        }});

        ResultVo result = dictController.map("type");
        Assert.assertNotNull(result);
    }

    @Test
    public void testDetail() throws Exception {
        when(dictService.findDictById(anyLong())).thenReturn(new DictVo());

        ResultVo result = dictController.detail(Long.valueOf(1));
        Assert.assertNotNull(result);
    }

    @Test
    public void testAdd() throws Exception {
        when(dictService.saveDict(any())).thenReturn(new DictVo());

        ResultVo result = dictController.add(new DictVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        when(dictService.updateDict(any())).thenReturn(new DictVo());

        ResultVo result = dictController.update(new DictVo());
        Assert.assertNotNull(result);
    }

    @Test
    public void testDelete() throws Exception {
        when(dictService.deleteById(anyLong())).thenReturn(0);
        when(resultVo.getInstance(anyString())).thenReturn(new ResultVo());

        ResultVo result = dictController.delete(Long.valueOf(1));
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme