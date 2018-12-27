package com.univer.base.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.univer.base.bo.UserBo;
import com.univer.base.constant.MsgConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author guwei
 *
 * 控制层授权基类
 */
public class AuthorizationController<T> extends BaseController<T> {

	@Autowired
	protected UserBo loginUser;
	
	@Autowired
	private StringRedisTemplate template;

	@ModelAttribute
	protected void init(@RequestHeader(name = "Univer-Code", required = true) String code) throws JsonParseException, JsonMappingException, UnsupportedEncodingException, IOException {
		resultVo.getInstance(MsgConstant.REQUEST_ERROR);
		String uuidValue = template.opsForValue().get(code);
		if(uuidValue != null) {
			loginUser = objectMapper.readValue(uuidValue, UserBo.class);
		}
	}
}
