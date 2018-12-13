package com.univer.base.bo;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author guwei
 */
@Component
public class FuncBo {

    /**ID*/
    private Long funcId;
    /**编号*/
    private String code;
    /**名称*/
    private String name;
    /**描述*/
    private String description;
    /**路径*/
    private String url;
    /**图标*/
    private String icon;
    /**类型*/
    private String type;
    /**序号*/
    private Long number;
    /**父ID*/
    private Long parentId;
    /**状态*/
    private String status;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
