package com.univer.base.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author guwei
 *
 * 定义Header
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
@Scope("prototype")
public class UserBo {

    /**用户ID*/
	private Long userId;
    /**用户编号*/
	private String code;
    /**用户名*/
	private String username;
    /**用户名称*/
	private String nickname;
    /**手机号*/
	private String phone;
    /**邮箱*/
	private String email;
    /**用户密码*/
	private String password;
    /**用户类型*/
	private String type;
    /**头像地址*/
	private String avatar;
    /**描述*/
	private String description;
    /**组织机构ID*/
	private Long orgId;
    /**组织机构名称*/
	private String orgName;
    /**创建者*/
	private Long createrId;
    /**创建者名称*/
	private String createrName;
    /**状态*/
	private String status;
    /**创建时间*/
	private Date createTime;
    /**更新时间*/
	private Date updateTime;
    /**角色列表*/
    private List<RoleBo> roleVoList;
    /**功能列表*/
    private List<FuncBo> funcVoList;
    /**令牌*/
	private  JwtToken jwtToken;
	/**用户在任务中承担的角色*/
	private String taskRole;

	private String taskRoleView;
	/**
	 * 该标注员 标注数量
	 */
	private Long tagNum;
	/**
	 * 该标注员 标注可用数量
	 */
	private Long tagAvailNum;
	/**
	 * 该标注员 审核通过的数量
	 */
	private Long tagByAuditNum;
	/**
	 * 该该标注员 被审核驳回的数量
	 */
	private Long tagByRejectNum;
	/**
	 * 该标注员审核通过率
	 */
	private Long tagAuditRatio;
	/**
	 * 该审核员 审核数量
	 */
	private Long auditNum;
	/**
	 * 该审核员 驳回到标记员的数量
	 */
	private Long auditRejectNum;

	/**
	 * 该审核员被 验收通过的数量
	 */
	private Long auditByAcceptNum;
	/**
	 * 该审核员 被验收驳回数量
	 */
	private Long auditByRejectNum;
	/**
	 *该审核员验收通过率
	 */
	private Long auditAcceptRatio;

	/**
	 * 该验收员 验收数量
	 */
	private Long accpetNum;

	/**
	 *该验收员 验收驳回数量
	 */
	private Long acceptRejectNum;

	/**
	 * 该验收员通过  可用数量
	 */
	private Long acceptAvailNum;

	/**
	 * 该验收员  验收通过率
	 */
	private Long acceptRatio;

	/**
	 * 标记/可用  数量  标记员
	 */
	private String tagAvai;
	/**
	 * 已审核/驳回  数量  标记员
	 */
	private String auditedRejected;
	/**
	 * 审核数量/驳回  数量  审核员
	 */
	private String auditReject;
	/**
	 * 已验收/驳回  数量  审核员
	 */
	private String acceptedRejeced;
	/**
	 * 验收数量/验收驳回  验收员
	 */
	private String acceptRject;

	public UserBo() {
		super();
	}

	public UserBo(Long userId, String code, String username, String nickname, String phone, String email) {
		this.userId = userId;
		this.code = code;
		this.username = username;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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

    public List<RoleBo> getRoleVoList() {
        return roleVoList;
    }

    public void setRoleVoList(List<RoleBo> roleVoList) {
        this.roleVoList = roleVoList;
    }

    public List<FuncBo> getFuncVoList() {
        return funcVoList;
    }

    public void setFuncVoList(List<FuncBo> funcVoList) {
        this.funcVoList = funcVoList;
    }

    public JwtToken getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(JwtToken jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getTaskRole() {
		return taskRole;
	}

	public void setTaskRole(String taskRole) {
		this.taskRole = taskRole;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public Long getTagNum() {
		return tagNum;
	}

	public void setTagNum(Long tagNum) {
		this.tagNum = tagNum;
	}

	public Long getTagAvailNum() {
		return tagAvailNum;
	}

	public void setTagAvailNum(Long tagAvailNum) {
		this.tagAvailNum = tagAvailNum;
	}

	public Long getTagByAuditNum() {
		return tagByAuditNum;
	}

	public void setTagByAuditNum(Long tagByAuditNum) {
		this.tagByAuditNum = tagByAuditNum;
	}

	public Long getTagByRejectNum() {
		return tagByRejectNum;
	}

	public void setTagByRejectNum(Long tagByRejectNum) {
		this.tagByRejectNum = tagByRejectNum;
	}

	public Long getTagAuditRatio() {
		return tagAuditRatio;
	}

	public void setTagAuditRatio(Long tagAuditRatio) {
		this.tagAuditRatio = tagAuditRatio;
	}

	public Long getAuditNum() {
		return auditNum;
	}

	public void setAuditNum(Long auditNum) {
		this.auditNum = auditNum;
	}

	public Long getAuditRejectNum() {
		return auditRejectNum;
	}

	public void setAuditRejectNum(Long auditRejectNum) {
		this.auditRejectNum = auditRejectNum;
	}

	public Long getAuditByAcceptNum() {
		return auditByAcceptNum;
	}

	public void setAuditByAcceptNum(Long auditByAcceptNum) {
		this.auditByAcceptNum = auditByAcceptNum;
	}

	public Long getAuditByRejectNum() {
		return auditByRejectNum;
	}

	public void setAuditByRejectNum(Long auditByRejectNum) {
		this.auditByRejectNum = auditByRejectNum;
	}

	public Long getAuditAcceptRatio() {
		return auditAcceptRatio;
	}

	public void setAuditAcceptRatio(Long auditAcceptRatio) {
		this.auditAcceptRatio = auditAcceptRatio;
	}

	public Long getAccpetNum() {
		return accpetNum;
	}

	public void setAccpetNum(Long accpetNum) {
		this.accpetNum = accpetNum;
	}

	public Long getAcceptRejectNum() {
		return acceptRejectNum;
	}

	public void setAcceptRejectNum(Long acceptRejectNum) {
		this.acceptRejectNum = acceptRejectNum;
	}

	public Long getAcceptAvailNum() {
		return acceptAvailNum;
	}

	public void setAcceptAvailNum(Long acceptAvailNum) {
		this.acceptAvailNum = acceptAvailNum;
	}

	public Long getAcceptRatio() {
		return acceptRatio;
	}

	public void setAcceptRatio(Long acceptRatio) {
		this.acceptRatio = acceptRatio;
	}

	public String getTagAvai() {
		return tagAvai;
	}

	public void setTagAvai(String tagAvai) {
		this.tagAvai = tagAvai;
	}

	public String getAuditedRejected() {
		return auditedRejected;
	}

	public void setAuditedRejected(String auditedRejected) {
		this.auditedRejected = auditedRejected;
	}

	public String getAuditReject() {
		return auditReject;
	}

	public void setAuditReject(String auditReject) {
		this.auditReject = auditReject;
	}

	public String getAcceptedRejeced() {
		return acceptedRejeced;
	}

	public void setAcceptedRejeced(String acceptedRejeced) {
		this.acceptedRejeced = acceptedRejeced;
	}

	public String getAcceptRject() {
		return acceptRject;
	}

	public void setAcceptRject(String acceptRject) {
		this.acceptRject = acceptRject;
	}

	public String getTaskRoleView() {
		return taskRoleView;
	}

	public void setTaskRoleView(String taskRoleView) {
		this.taskRoleView = taskRoleView;
	}
}
