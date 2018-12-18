package com.univer.account.po;

import com.univer.account.validation.*;
import com.univer.base.po.BaseEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author guwei
 */
public class User extends BaseEntity {
    /**
     * ID
     */
    @NotNull(message = "{user.id.not.null}", groups = { UserUpdate.class })
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 编码
     */
    @Null
    private String code;

    /**
     * 用户名
     */
    @NotNull(message = "{user.name.not.null}", groups = { UserAdd.class })
    @Size(min = 1, max = 25, message = "{user.name.size}", groups = { UserAdd.class, UserUpdate.class })
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]*$", message = "{user.name.pattern}", groups = { UserAdd.class, UserUpdate.class })
    private String username;

    /**
     * 名字
     */
    @NotNull(message = "{user.name.not.null}", groups = { UserAdd.class })
    @Size(min = 2, max = 64, message = "{user.name.size}", groups = { UserAdd.class, UserUpdate.class })
    @Pattern(regexp = "^\\S+$", message = "{user.name.pattern}", groups = { UserAdd.class, UserUpdate.class })
    private String name;

    /**
     * 性别
     */
    @NotNull(message = "{user.gender.not.null}", groups = { UserAdd.class })
    @Size(min = 2, max = 64, message = "{user.gender.size}", groups = { UserAdd.class, UserUpdate.class })
    @Pattern(regexp = "^\\S+$", message = "{user.gender.pattern}", groups = { UserAdd.class, UserUpdate.class })
    private String gender;

    /**
     * 邮箱
     */
    @NotNull(message = "{user.email.not.null}", groups = { UserAdd.class, EmailCaptcha.class, EmailCaptchaValid.class,PasswordChange.class })
    @Pattern(regexp = "^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "{user.email.pattern}", groups = { UserAdd.class, UserUpdate.class, EmailCaptcha.class, EmailCaptchaValid.class,PasswordChange.class })
    @Size(min = 6, max = 64, message = "{user.email.size}", groups = { UserAdd.class, UserUpdate.class, EmailCaptcha.class, EmailCaptchaValid.class,PasswordChange.class })
    private String email;

    /**
     * 手机号码
     */
    @NotNull(message = "{user.phone.not.null}", groups = { UserAdd.class })
    @Size(min = 11, max = 11, message = "{user.phone.size}", groups = { UserAdd.class, UserUpdate.class })
    @Pattern(regexp = "^[0-9]+$", message = "{user.phone.pattern}", groups = { UserAdd.class, UserUpdate.class })
    private String phone;

    /**
     * 密码
     */
    @NotNull(message = "{user.password.not.null}", groups = { UserAdd.class, PasswordUpdate.class })
    @Size(min = 8, max = 20, message = "{user.password.size}", groups = { UserAdd.class, PasswordUpdate.class })
    @Pattern(regexp = "^\\S+$", message = "{user.password.pattern}", groups = { UserAdd.class, PasswordUpdate.class })
    private String password;

    /**
     * 类型
     */
    private String type;

    /**
     * 头像
     */
    @Size(min = 1, max = 1024, message = "{user.avatar.max}", groups = { UserAdd.class, UserUpdate.class })
    private String avatar;

    /**
     * 是否需要验证码，0：不需要，1：需要
     */
    @Column(name = "captcha_status")
    private Boolean captchaStatus;

    /**
     * 是否已重置密码，0：未重置，1：已重置
     */
    @Column(name = "reset_status")
    private Boolean resetStatus;

    /**
     * 描述
     */
    @Size(min = 0, max = 300, message = "{user.description.max}", groups = { UserAdd.class, UserUpdate.class })
    private String description;

    /**
     * 组织机构ID
     */
    @NotNull(message = "{user.org.id.not.null}", groups = { UserAdd.class })
    @Column(name = "org_id")
    private Long orgId;

    /**
     * 创建者
     */
    @Column(name = "creater_id")
    private Long createrId;

    /**
     * 状态
     */
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{user.status.pattern}", groups = { UserAdd.class, UserUpdate.class })
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
     * 构造器
     */
    public User(){
        super();
    }

    /**
     * 构造器
     */
    public User(Long userId, String code, String username, String name, String phone, String email,String gender) {
        super();
        this.userId = userId;
        this.code = code;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    /**
     * 获取ID
     *
     * @return user_id - ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置ID
     *
     * @param userId ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取编码
     *
     * @return code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置昵称
     *
     * @param name 昵称
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 获取是否需要验证码，0：不需要，1：需要
     *
     * @return captcha_status - 是否需要验证码，0：不需要，1：需要
     */
    public Boolean getCaptchaStatus() {
        return captchaStatus;
    }

    /**
     * 设置是否需要验证码，0：不需要，1：需要
     *
     * @param captchaStatus 是否需要验证码，0：不需要，1：需要
     */
    public void setCaptchaStatus(Boolean captchaStatus) {
        this.captchaStatus = captchaStatus;
    }

    /**
     * 获取是否已重置密码，0：未重置，1：已重置
     *
     * @return reset_status - 是否已重置密码，0：未重置，1：已重置
     */
    public Boolean getResetStatus() {
        return resetStatus;
    }

    /**
     * 设置是否已重置密码，0：未重置，1：已重置
     *
     * @param resetStatus 是否已重置密码，0：未重置，1：已重置
     */
    public void setResetStatus(Boolean resetStatus) {
        this.resetStatus = resetStatus;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
     * 获取组织机构ID
     *
     * @return org_id - 组织机构ID
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 设置组织机构ID
     *
     * @param orgId 组织机构ID
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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