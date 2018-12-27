package com.univer.account.po;

import com.univer.account.validation.OrgAdd;
import com.univer.account.validation.OrgUpdate;
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
 * 组织机构表
 * @author hongjiao
 */
public class Org extends BaseEntity {
    /**
     * ID
     */
    @Id
    @Column(name = "org_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "{org.id.not.null}",groups = {OrgUpdate.class})
    private Long orgId;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    @NotBlank(message = "{org.name.not.blank}",groups = {OrgAdd.class})
    @Length(min = 1, max = 32, message = "{org.name.length}", groups = { OrgAdd.class,OrgUpdate.class })
    @Pattern(regexp = "^\\S+$", message = "{org.name.pattern}", groups = { OrgAdd.class,OrgUpdate.class })
    private String name;

    /**
     * 类型
     */
    @NotBlank(message = "{org.type.not.blank}",groups = {OrgAdd.class})
    @Length(min = 2, max = 64, message = "{org.type.length}", groups = { OrgAdd.class,OrgUpdate.class })
    @Pattern(regexp = "^\\S+$", message = "{org.type.pattern}", groups = { OrgAdd.class,OrgUpdate.class})
    private String type;

    /**
     * 序号
     */
    private Long number;

    /**
     * 描述
     */
    @Length(max = 300,message = "{org.description.maxLength}", groups = {OrgAdd.class, OrgUpdate.class})
    private String description;

    /**
     * 父ID
     */
    @Column(name = "parent_id")
    @NotNull(message = "{org.parentId.not.null}",groups = {OrgAdd.class})
    private Long parentId;

    /**
     * 状态
     */
    @NotBlank(message = "{org.status.not.blank}",groups = {OrgAdd.class})
    private String status;

    /**
     * 创建者
     */
    @Column(name = "creater_id")
    private Long createrId;

    /**
     * 根父级ID
     */
    @Column(name = "root_id")
    private Long rootId;

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
     * @return org_id - ID
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 设置ID
     *
     * @param orgId ID
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
     * 获取序号
     *
     * @return number - 序号
     */
    public Long getNumber() {
        return number;
    }

    /**
     * 设置序号
     *
     * @param number 序号
     */
    public void setNumber(Long number) {
        this.number = number;
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
     * 获取父ID
     *
     * @return parent_id - 父ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父ID
     *
     * @param parentId 父ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 获取顶级机构Id
     *
     * @return root_id - 顶级机构Id
     */
    public Long getRootId() {
        return rootId;
    }

    /**
     * 设置顶级机构Id
     *
     * @param rootId 顶级机构Id
     */
    public void setRootId(Long rootId) {
        this.rootId = rootId;
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