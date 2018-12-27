package com.univer.account.po;

import com.univer.account.validation.RoleAdd;
import com.univer.account.validation.RoleUpdate;
import com.univer.base.po.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
/**
 * 角色表
 * @author hongjiao
 */
public class Role extends BaseEntity {
    /**
     * ID
     */
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "{role.id.not.null}",groups = {RoleUpdate.class})
    private Long roleId;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    @NotBlank(message = "{role.name.not.blank}",groups = {RoleAdd.class})
    @Length(min = 2,max = 64,message = "{role.name.length}",groups = {RoleAdd.class,RoleUpdate.class})
    @Pattern(regexp = "^\\S+$", message = "{role.name.pattern}", groups = { RoleAdd.class,RoleUpdate.class })
    private String name;

    /**
     * 描述
     */
    @Length(max = 1024,message = "{role.description.maxLength}", groups = { RoleAdd.class,RoleUpdate.class })
    private String description;

    /**
     * 类型
     */
    @NotBlank(message = "{role.type.not.blank}",groups = {RoleAdd.class})
    @Length(min = 2, max = 16, message = "{role.type.length}", groups = { RoleAdd.class,RoleUpdate.class })
    @Pattern(regexp = "^\\S+$", message = "{role.type.pattern}", groups = { RoleAdd.class,RoleUpdate.class})
    private String type;

    /**
     * 创建者
     */
    @Column(name = "creater_id")
    private Long createrId;

    /**
     * 状态
     */
    @NotBlank(message = "{role.status.not.blank}",groups = {RoleAdd.class})
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

    /**
     * 获取ID
     *
     * @return role_id - ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置ID
     *
     * @param roleId ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取编号
     *
     * @return code - 编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编号
     *
     * @param code 编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取创建者
     *
     * @return creater_id - 创建者
     */
    public Long getCreaterId() {
        return createrId;
    }

    /**
     * 设置创建者
     *
     * @param createrId 创建者
     */
    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
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