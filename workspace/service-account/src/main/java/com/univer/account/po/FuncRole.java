package com.univer.account.po;

import com.univer.base.po.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * 功能角色中间表
 * @author hongjiao
 */
@Table(name = "func_role")
public class FuncRole extends BaseEntity {
    /**
     * ID
     */
    @Id
    @Column(name = "func_role_id")
    private Long funcRoleId;

    /**
     * 功能ID
     */
    @Column(name = "func_id")
    private Long funcId;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @com.fasterxml.jackson.annotation.JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @com.fasterxml.jackson.annotation.JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public FuncRole() {
    }

    public FuncRole(Long funcId, Long roleId, String status) {
        this.funcId = funcId;
        this.roleId = roleId;
        this.status = status;
    }

    /**
     * 获取ID
     *
     * @return func_role_id - ID
     */
    public Long getFuncRoleId() {
        return funcRoleId;
    }

    /**
     * 设置ID
     *
     * @param funcRoleId ID
     */
    public void setFuncRoleId(Long funcRoleId) {
        this.funcRoleId = funcRoleId;
    }

    /**
     * 获取功能ID
     *
     * @return func_id - 功能ID
     */
    public Long getFuncId() {
        return funcId;
    }

    /**
     * 设置功能ID
     *
     * @param funcId 功能ID
     */
    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}