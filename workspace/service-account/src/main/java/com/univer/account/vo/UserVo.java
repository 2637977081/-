package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.User;
import com.univer.account.validation.*;
import com.univer.base.bo.JwtToken;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author guwei
 */
@JsonInclude(Include.NON_NULL)
@Component
@Scope("prototype")
public class UserVo extends User {

    /**通用登录（用户名或邮箱）*/
    @NotNull(message = "{user.common.name.not.null}", groups = {  })
    @Size(min = 1, max = 25, message ="{user.common.name.size}", groups = {  })
    private String commonName;
    /**随机码*/
    @NotNull(message = "{user.random.not.null}", groups = { Captcha.class, EmailCaptcha.class, EmailCaptchaValid.class })
    @Pattern(regexp = "^\\S+$", message = "{user.random.pattern}", groups = { Captcha.class, EmailCaptcha.class, EmailCaptchaValid.class })
    private String random;
    /**验证码*/
    @Size(min = 4, max = 6, message ="{user.captcha.size}", groups = { Login.class, EmailCaptchaValid.class })
    private String captcha;
    /**创建者名称*/
    private String createrName;
    /**新密码*/
    @NotNull(message = "{user.new.password.not.null}", groups = { PasswordUpdate.class, PasswordChange.class })
    @Size(min = 8, max = 20, message = "{user.new.password.size}", groups = { PasswordUpdate.class, PasswordChange.class })
    @Pattern(regexp = "^\\S+$", message = "{user.new.password.pattern}", groups = { PasswordUpdate.class, PasswordChange.class })
    private String newPassword;
    /**确认密码*/
    @NotNull(message = "{user.confirm.password.not.null}", groups = { PasswordUpdate.class, PasswordChange.class })
    @Size(min = 8, max = 20, message = "{user.confirm.password.size}", groups = { PasswordUpdate.class, PasswordChange.class })
    @Pattern(regexp = "^\\S+$", message = "{user.confirm.password.pattern}", groups = { PasswordUpdate.class, PasswordChange.class })
    private String confirmPassword;
    /**角色列表*/
    private List<RoleVo> roleVoList;
    /**功能列表*/
    private List<FuncVo> funcVoList;
    /**功能树*/
    private FuncTreeVo funcTreeVo;
    /**token对象*/
    private JwtToken jwtToken;
    /**角色名*/
    private String roleName;
    /**组织结构名*/
    private String orgName;
    /**
     * 构造器
     */
    public UserVo() {
        super();
    }

    /**
     * 构造器
     */
    public UserVo(Long userId, String code, String username, String nickname, String phone, String email) {
        super(userId, code, username, nickname, phone, email);
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public JwtToken getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(JwtToken jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<RoleVo> getRoleVoList() {
        return roleVoList;
    }

    public void setRoleVoList(List<RoleVo> roleVoList) {
        this.roleVoList = roleVoList;
    }

    public List<FuncVo> getFuncVoList() {
        return funcVoList;
    }

    public void setFuncVoList(List<FuncVo> funcVoList) {
        this.funcVoList = funcVoList;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOrgName() {return orgName;}

    public void setOrgName(String orgName) {this.orgName = orgName;}

    public FuncTreeVo getFuncTreeVo() {
        return funcTreeVo;
    }

    public void setFuncTreeVo(FuncTreeVo funcTreeVo) {
        this.funcTreeVo = funcTreeVo;
    }
}
