package com.univer.account.controller;

import com.github.pagehelper.PageInfo;
import com.univer.account.po.Role;
import com.univer.account.po.UserRole;
import com.univer.account.service.FuncService;
import com.univer.account.service.RoleService;
import com.univer.account.service.UserRoleService;
import com.univer.account.validation.RoleAdd;
import com.univer.account.validation.RoleUpdate;
import com.univer.account.vo.FuncVo;
import com.univer.account.vo.RoleVo;
import com.univer.account.vo.UserVo;
import com.univer.base.constant.MsgConstant;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.VoUtils;
import com.univer.base.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色相关功能
 * @author hongjiao
 */
@RestController
@RequestMapping("/role/")
@Scope("prototype")
public class RoleController extends AuthorizationController<Object> {

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleVo roleVo;

	@Autowired
	private RoleService roleService;
	@Autowired
    private UserRoleService userRoleService;
	@Autowired
	private FuncService funcService;

	/** 
     * 列表查询
     */
	@GetMapping("list")
	public ResultVo list(RoleVo temp) throws Exception {
        VoUtils.copyProperties(temp, roleVo, "name","status");
        List<RoleVo> list = roleService.findByPage(roleVo);
        PageInfo<RoleVo> pageInfo = new PageInfo<RoleVo>(list);
        resultVo.getInstance(HttpStatus.OK.toString(), pageInfo);
		return resultVo;
	}

	/**
	 * 查询用户的角色和功能列表
	 */
	@GetMapping("func/list/{userId}")
	public ResultVo funcRoleList(@PathVariable Long userId) throws Exception {
		List<RoleVo> roleVoList = roleService.findRoleByUserId(userId,null);
		UserVo userVo = new UserVo();
		List<FuncVo> funcVoList = funcService.getFuncVoByUserId(userId,null);
		userVo.setRoleVoList(roleVoList);
		userVo.setFuncVoList(funcVoList);
		resultVo.getInstance(HttpStatus.OK.toString(), userVo);
		return resultVo;
	}
	
	/** 
     * 查询详情
     */
	@GetMapping("detail/{roleId}")
	public ResultVo detail(@PathVariable Long roleId) throws Exception {
		RoleVo roleVo = roleService.findRoleById(roleId);
		if(roleVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), roleVo);
        } else {
            resultVo.getInstance(MsgConstant.NO_DATA, roleVo);
        }
		return resultVo;
	}
	
	/** 
     * 创建
     */
	@PostMapping("add")
	public ResultVo add(@RequestBody @Validated( {RoleAdd.class }) RoleVo temp) throws Exception {
        VoUtils.copyProperties(temp, roleVo, "name","description","type","status","funcList");
		// 检查status是否正确
		if (StatusEnum.getStatus(roleVo.getStatus()) == null){
			resultVo.getInstance(MsgConstant.INVALID_DATA);
			return resultVo;
		}
		Role role = roleService.findBy("name",roleVo.getName());
		if (role != null){
			resultVo.getInstance(com.univer.account.constant.MsgConstant.ROLE_EXISTED);
			return resultVo;
		}
        roleVo.setCreaterId(loginUser.getUserId());
        roleVo = roleService.saveRole(roleVo);
		if (roleVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), roleVo);
		} else {
            resultVo.getInstance(MsgConstant.CREATE_ERROR, roleVo);
        }
		return resultVo;
	}
	
	/** 
     * 更新
     */
	@PostMapping("update")
	public ResultVo update(@RequestBody @Validated( {RoleUpdate.class }) RoleVo temp) throws Exception {
        VoUtils.copyProperties(temp, roleVo, "roleId","name","description","type","status","funcList");
        if (!StringUtils.isEmpty(roleVo.getStatus()) && StatusEnum.getStatus(roleVo.getStatus()) == null){
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }else {
			if (roleVo.getName() != null){
				Role role = roleService.findBy("name",roleVo.getName());
				if (role != null && role.getRoleId().longValue() != roleVo.getRoleId().longValue()) {
					resultVo.getInstance(com.univer.account.constant.MsgConstant.ROLE_EXISTED);
					return resultVo;
				}
			}
            roleVo = roleService.updateRole(roleVo);
            if (roleVo != null) {
                resultVo.getInstance(HttpStatus.OK.toString(), roleVo);
            } else {
                resultVo.getInstance(MsgConstant.UPDATE_ERROR, roleVo);
            }
        }
		return resultVo;
	}

	/** 
     * 删除
     */
	@DeleteMapping("delete/{id}")
	public ResultVo delete(@PathVariable Long id) throws Exception {
        // 检查是否存在用户
        List<UserRole> userRole =  userRoleService.findUserRole(id,null);
        if (userRole != null && userRole.size() >0){
            resultVo.getInstance(com.univer.account.constant.MsgConstant.ROLE_EXISTED_USER);
            return resultVo;
        }
		int num = roleService.deleteById(id);
		if (num == 1) {
            resultVo.getInstance(HttpStatus.OK.toString());
		}
		return resultVo;
	}

	/** 
     * 批量删除
     */
	@DeleteMapping("deleteList")
	public ResultVo delete(@RequestParam(defaultValue = "") String ids) throws Exception {
		int num = roleService.deleteByIds(ids);
		if (num > 0) {
            resultVo.getInstance(HttpStatus.OK.toString());
		}
		return resultVo;
	}
}