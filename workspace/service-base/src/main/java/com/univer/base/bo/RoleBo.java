package com.univer.base.bo;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author guwei
 *
 * 角色类
 */
@Component
public class RoleBo {

    /**ID*/
    private Long roleId;
    /**编号*/
    private String code;
    /**名称*/
    private String name;
    /**描述*/
    private String description;
    /**类型*/
    private String type;
    /**创建者*/
    private Long createrId;
    /**状态*/
    private String status;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
