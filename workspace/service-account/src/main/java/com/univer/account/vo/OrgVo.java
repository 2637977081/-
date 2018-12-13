package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.Org;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 组织机构返回类
 * @author hongjiao
 */
@JsonInclude(Include.NON_NULL)
@Component
@Scope("prototype")
public class OrgVo extends Org {
    private OrgVo parent;

    public OrgVo getParent() {
        return parent;
    }

    public void setParent(OrgVo parent) {
        this.parent = parent;
    }

}
