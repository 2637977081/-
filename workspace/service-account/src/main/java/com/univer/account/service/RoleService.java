package com.univer.account.service;

import com.github.pagehelper.PageHelper;
import com.univer.account.mapper.RoleMapper;
import com.univer.account.po.Func;
import com.univer.account.po.FuncRole;
import com.univer.account.po.Role;
import com.univer.account.vo.RoleVo;
import com.univer.base.enums.StatusEnum;
import com.univer.base.service.BaseService;
import com.univer.base.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色表业务层
 * @author hongjiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleService extends BaseService<Role> {

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private FuncRoleService funcRoleService;
	@Autowired
	private FuncService funcService;


	/**
	 * 分页查询
	 */
	public List<RoleVo> findByPage(RoleVo roleVo) {
		if (roleVo.getPage() != null && roleVo.getRows() != null) {
			PageHelper.startPage(roleVo.getPage(), roleVo.getRows());
		}
		return roleMapper.findRoleList(roleVo.getName(),roleVo.getStatus());
	}

	/**
	 * 查询角色信息
	 */
	public RoleVo findRoleById(Long id) {
		RoleVo roleVo = null;
		Role role = roleMapper.selectByPrimaryKey(id);
		if(role != null) {
            roleVo = new RoleVo();
            BeanUtils.copyProperties(role, roleVo);
            roleVo.setFuncList(funcService.findByRoleId(id,null));
        }
		return roleVo;
	}

	/**
	 * 查询用户的角色信息
	 */
	public List<RoleVo> findRoleByUserId(Long userId,String status) {
		List<RoleVo> roleVoList = roleMapper.getRoleByUserId(userId,status);
		return roleVoList;
	}

	/**
	 * 创建
	 */
	public RoleVo saveRole(RoleVo roleVo) {
		Role role = new Role();
		BeanUtils.copyProperties(roleVo, role);
        role.setCode(UUIDUtil.getUUID());
		roleMapper.insertSelective(role);
		if (roleVo.getFuncList() != null && !roleVo.getFuncList().isEmpty()){
			List<FuncRole> funcRoleList = new ArrayList<FuncRole>();
			for(Func func : roleVo.getFuncList()) {
				FuncRole funcRole = new FuncRole(func.getFuncId(), role.getRoleId(),StatusEnum.ENABLED.getStatus());
				funcRoleList.add(funcRole);
			}
			funcRoleService.save(funcRoleList);
		}
        return findRoleById(role.getRoleId());
	}

    /**
     * 更新
     */
    public RoleVo updateRole(RoleVo roleVo) {
        Role role = new Role();
        BeanUtils.copyProperties(roleVo, role);
        roleMapper.updateByPrimaryKeySelective(role);
		if (roleVo.getFuncList() != null && roleVo.getFuncList().size() > 0){
			funcRoleService.deleteFuncRoleByRoleId(role.getRoleId());
			List<FuncRole> funcRoleList = new ArrayList<FuncRole>();
			for(Func func : roleVo.getFuncList()) {
				FuncRole funcRole = new FuncRole(func.getFuncId(), role.getRoleId(),StatusEnum.ENABLED.getStatus());
				funcRoleList.add(funcRole);
			}
			funcRoleService.save(funcRoleList);
		}
        return findRoleById(role.getRoleId());
    }

}
