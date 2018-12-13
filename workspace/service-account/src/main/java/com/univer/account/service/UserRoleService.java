package com.univer.account.service;

import com.github.pagehelper.PageHelper;
import com.univer.account.mapper.UserRoleMapper;
import com.univer.account.po.UserRole;
import com.univer.account.vo.UserRoleVo;
import com.univer.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author guwei
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleService extends BaseService<UserRole> {

	private static final Logger log = LoggerFactory.getLogger(UserRoleService.class);

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
	 * 分页查询
	 */
	public List<UserRoleVo> findByPage(UserRoleVo userRoleVo) {
		if (userRoleVo.getPage() != null && userRoleVo.getRows() != null) {
			PageHelper.startPage(userRoleVo.getPage(), userRoleVo.getRows());
		}
		return null;
	}

	/**
	 * 查询用户信息
	 */
	public UserRoleVo findUserRoleById(Long id) {
		UserRoleVo userRoleVo = null;
		UserRole userRole = userRoleMapper.selectByPrimaryKey(id);
		if(userRole != null) {
            userRoleVo = new UserRoleVo();
            BeanUtils.copyProperties(userRole, userRoleVo);
        }
		return userRoleVo;
	}

	/**
	 * 查询用户信息
	 */
	public List<UserRole> findUserRole(Long roleId,Long userId) {
		Condition condition = new Condition(UserRole.class);
		Example.Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("roleId",roleId);
		criteria.andEqualTo("userId",userId);
		UserRoleVo userRoleVo = null;
		List<UserRole> userRoleList = userRoleMapper.selectByCondition(condition);
		return userRoleList;
	}

	/**
	 * 创建
	 */
	public UserRoleVo saveUserRole(UserRoleVo userRoleVo) {
		UserRole userRole = new UserRole();
		BeanUtils.copyProperties(userRoleVo, userRole);
        userRoleVo = null;
		int result = userRoleMapper.insertSelective(userRole);
		if(result == 1) {
            userRoleVo = findUserRoleById(userRole.getUserRoleId());
        }
        return userRoleVo;
	}

    /**
     * 更新
     */
    public UserRoleVo updateUserRole(UserRoleVo userRoleVo) {
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(userRoleVo, userRole);
        userRoleVo = null;
        int result = userRoleMapper.updateByPrimaryKeySelective(userRole);
        if(result == 1) {
            userRoleVo = findUserRoleById(userRole.getUserRoleId());
        }
        return userRoleVo;
    }

    /**
     * 根据用户ID删除关系
     */
	public void deleteUserRoleByUserId(Long userId) {
        Condition condition = new Condition(UserRole.class);
        Condition.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId", userId);
        userRoleMapper.deleteByCondition(condition);
	}

    /**
     * 根据角色ID删除关系
     */
	public void deleteUserRoleByRoleId(Long roleId) {
		Condition condition = new Condition(UserRole.class);
		Condition.Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("roleId", roleId);
		userRoleMapper.deleteByCondition(condition);
	}
}
