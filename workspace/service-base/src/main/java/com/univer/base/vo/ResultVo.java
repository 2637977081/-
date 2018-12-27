package com.univer.base.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author guwei
 *
 * 消息返回体
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
@Scope("prototype")
public class ResultVo<T> {

    @Autowired
    private MessageSource messageSource;

	private String code;
	private String msg;
	private T data;

    public ResultVo() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) { this.msg = msg; }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultVo getInstance(String code) {
        this.code = code;
        this.msg = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        return this;
    }

    public ResultVo getInstance(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResultVo getInstance(String code, T data) {
        this.code = code;
        this.msg = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        this.data = data;
        return this;
    }
}
