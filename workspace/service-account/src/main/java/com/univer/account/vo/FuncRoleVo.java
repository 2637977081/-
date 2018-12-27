package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.FuncRole;
import org.springframework.stereotype.Component;

/**
 * 功能角色中间表返回类
 * @author hongjiao
 */
@JsonInclude(Include.NON_NULL)
@Component
public class FuncRoleVo extends FuncRole {

}
