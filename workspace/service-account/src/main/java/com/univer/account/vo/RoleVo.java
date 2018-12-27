package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.Func;
import com.univer.account.po.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色返回类
 * @author hongjiao
 */
@JsonInclude(Include.NON_NULL)
@Component
@Scope("prototype")
public class RoleVo extends Role {

    private Long number;

    private List<Func> funcList;

    public List<Func> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<Func> funcList) {
        this.funcList = funcList;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    /**
     * 过滤登录时的冗余字段
     */
    public static void filterRoleVoListByLogin(List<RoleVo> roleVolist) {
        for (RoleVo roleVo: roleVolist ) {
            roleVo.setDescription(null);
            roleVo.setType(null);
            roleVo.setCreaterId(null);
            roleVo.setStatus(null);
            roleVo.setCreateTime(null);
            roleVo.setUpdateTime(null);
        }
    }
}
