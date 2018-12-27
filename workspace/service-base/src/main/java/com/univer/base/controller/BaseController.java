package com.univer.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.base.constant.MsgConstant;
import com.univer.base.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author guwei
 *
 * 控制层基类
 */
@CrossOrigin
public class BaseController<T> {

	@Autowired
    protected ObjectMapper objectMapper;

    @Autowired
	protected ResultVo<T> resultVo;

	@ModelAttribute
	protected void init() {
		resultVo.getInstance(MsgConstant.REQUEST_ERROR);
	}
}
