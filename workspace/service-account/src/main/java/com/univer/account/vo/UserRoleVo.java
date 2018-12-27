package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.UserRole;
import org.springframework.stereotype.Component;

/**
 * @author guwei
 */
@JsonInclude(Include.NON_NULL)
@Component
public class UserRoleVo extends UserRole {

}
