package com.univer.account.po;

import com.univer.account.validation.FuncAdd;
import com.univer.account.validation.FuncUpdate;
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
 * 功能表
 * @author hongjiao
 */
public class Func extends BaseEntity {
    /**
     * ID
     */
    @Id
    @Column(name = "func_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "{func.id.not.null}",groups = {FuncUpdate.class})
    private Long funcId;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    @NotNull(message = "{func.name.not.null}",groups = {FuncAdd.class})
    @Length(min = 2, max = 64, message = "{func.name.length}", groups = { FuncAdd.class,FuncUpdate.class })
    @Pattern(regexp = "^\\S+$", message = "{func.name.pattern}", groups = { FuncAdd.class,FuncUpdate.class })
    private String name;

    /**
     * 描述
     */
    @Length(max = 1024,message = "{func.description.maxLength}", groups = {FuncAdd.class, FuncUpdate.class})
    private String description;

    /**
     * 路径
     */
    @NotBlank(message = "{func.url.not.blank}",groups = {FuncAdd.class})
    @Length(max = 512, message = "{func.url.maxLength}", groups = { FuncAdd.class,FuncUpdate.class})
    private String url;

    /**
     * 图标
     */
    @Length(max = 16, message = "{func.icon.maxLength}", groups = { FuncAdd.class,FuncUpdate.class })
    private String icon;

    /**
     * 类型
     */
    @Length(max = 16, message = "{func.type.maxLength}", groups = { FuncAdd.class,FuncUpdate.class })
    @NotBlank( message = "{func.type.not.blank}", groups = { FuncAdd.class })
    private String type;

    /**
     * 序号
     */
    private Long number;

    /**
     * 父ID
     */
    @Column(name = "parent_id")
    @NotNull(message = "{func.parentId.not.null}",groups = {FuncAdd.class})
    private Long parentId;

    /**
     * 父根ID
     */
    @Column(name = "root_id")
    private Long rootId;

    /**
     * 状态
     */
    @NotBlank( message = "{func.status.not.blank}", groups = { FuncAdd.class })
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
     * @return func_id - ID
     */
    public Long getFuncId() {
        return funcId;
    }

    /**
     * 设置ID
     *
     * @param funcId ID
     */
    public void setFuncId(Long funcId) {
        this.funcId = funcId;
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
     * 获取路径
     *
     * @return url - 路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置路径
     *
     * @param url 路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * 获取父根ID
     *
     * @return root_id - 父根ID
     */
    public Long getRootId() {
        return rootId;
    }
    /**
     * 设置父根ID
     *
     * @param rootId 父根ID
     */
    public void setRootId(Long rootId) {
        this.rootId = rootId;
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