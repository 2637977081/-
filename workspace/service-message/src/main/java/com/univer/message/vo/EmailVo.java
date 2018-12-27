package com.univer.message.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.univer.message.po.Email;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
@Scope("prototype")
public class EmailVo extends Email {
}
