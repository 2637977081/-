package com.univer.account.service;

import com.github.pagehelper.PageHelper;
import com.univer.account.mapper.OrgMapper;
import com.univer.account.mapper.UserMapper;
import com.univer.account.po.Org;
import com.univer.account.po.User;
import com.univer.account.po.UserRole;
import com.univer.account.vo.FuncVo;
import com.univer.account.vo.RoleVo;
import com.univer.account.vo.UserVo;
import com.univer.base.enums.StatusEnum;
import com.univer.base.service.BaseService;
import com.univer.base.util.PatternUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guwei
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends BaseService<User> {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private OrgService orgService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private FuncService funcService;

    @Autowired
    private UserRoleService userRoleService;

	@Autowired
	private UserMapper userMapper;

	/**
	 * 分页查询
	 */
    public List<UserVo> findByPage(UserVo userVo) {
        if (userVo.getPage() != null && userVo.getRows() != null) {
            PageHelper.startPage(userVo.getPage(), userVo.getRows());
        }
        Map<String, Object> map = new HashMap<>(16);
        if (!StringUtils.isEmpty(userVo.getUsername())) {
            map.put("username", userVo.getUsername());
        }
        if (!StringUtils.isEmpty(userVo.getNickname())) {
            map.put("nickname", userVo.getNickname());
        }
        if (!StringUtils.isEmpty(userVo.getPhone())) {
            map.put("phone", userVo.getPhone());
        }
        if (!StringUtils.isEmpty(userVo.getEmail())) {
            map.put("email", userVo.getEmail());
        }
        if (!StringUtils.isEmpty(userVo.getType())) {
            map.put("type", userVo.getType());
        }
        if (!StringUtils.isEmpty(userVo.getOrgId())) {
            map.put("orgId", userVo.getOrgId());
        }
        if (!StringUtils.isEmpty(userVo.getCreaterId())) {
            map.put("createrId", userVo.getCreaterId());
        }
        if (!StringUtils.isEmpty(userVo.getStatus())) {
            map.put("status", userVo.getStatus());
        }
        if (!StringUtils.isEmpty(userVo.getRoleName())) {
            map.put("roleName", userVo.getRoleName());
        }
        map.put("notStatus",StatusEnum.DELETED.toString());
        return userMapper.selectUserVoByCondition(map);
    }

	/**
	 * 查询用户信息
	 */
	public UserVo findUserById(Long userId) {
		UserVo userVo = null;
		User user = userMapper.selectByPrimaryKey(userId);
		if(user != null) {
            userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            Org org = orgService.findOrgById(user.getOrgId());
            userVo.setOrgName(org.getName());
            // 查询用户拥有的角色
            List<RoleVo> roleVoList = roleService.findRoleByUserId(userId, null);
            RoleVo.filterRoleVoListByLogin(roleVoList);
            userVo.setRoleVoList(roleVoList);
            // 查询用户拥有的功能
            List<FuncVo> funcVoList = funcService.getFuncVoByUserId(userId, null);
            FuncVo.filterFuncVoListByLogin(funcVoList);
            userVo.setFuncVoList(funcVoList);
            userVo.setFuncTreeVo(funcService.getFuncTreeByUserId(userId,null));
        }
		return userVo;
	}

    /**
     * 根据登录信息查询用户信息
     */
    public UserVo findUser(String commonName) {
        UserVo userVo = null;
        Condition condition = new Condition(User.class);
        Condition.Criteria criteria = condition.createCriteria();
        conditionCommonName(commonName, criteria);
        List<User> userList = userMapper.selectByCondition(condition);
        if(userList != null && userList.size() == 1) {
            userVo = new UserVo();
            BeanUtils.copyProperties(userList.get(0), userVo);
            Org org = orgService.findOrgById(userList.get(0).getOrgId());
            userVo.setOrgName(org.getName());
            // 查询用户角色
            List<RoleVo> roleVoList = roleService.findRoleByUserId(userList.get(0).getUserId(), null);
            RoleVo.filterRoleVoListByLogin(roleVoList);
            userVo.setRoleVoList(roleVoList);
            // 查询用户拥有的功能
            List<FuncVo> funcVoList = funcService.getFuncVoByUserId(userList.get(0).getUserId(), null);
            FuncVo.filterFuncVoListByLogin(funcVoList);
            userVo.setFuncVoList(funcVoList);
            userVo.setFuncTreeVo(funcService.getFuncTreeByUserId(userList.get(0).getUserId(),null));
        }
        return userVo;
    }

    /**
     * 不等于此ID的账号是否存在
     */
    public UserVo findUser(Long userId, String commonName) {
        UserVo userVo = null;
        Condition condition = new Condition(User.class);
        Condition.Criteria criteria = condition.createCriteria();
        criteria.andNotEqualTo("userId", userId);
        conditionCommonName(commonName, criteria);
        List<User> userList = userMapper.selectByCondition(condition);
        if(userList != null && userList.size() == 1) {
            userVo = new UserVo();
            BeanUtils.copyProperties(userList.get(0), userVo);
        }
        return userVo;
    }

    /**
     * 组装账号条件
     */
    private void conditionCommonName(String commonName, Example.Criteria criteria) {
        if (PatternUtil.matchUsername(commonName)) {
            criteria.andEqualTo("username", commonName);
        }else if (PatternUtil.matchEmail(commonName)) {
            criteria.andEqualTo("email", commonName);
        }else if (PatternUtil.matchPhone(commonName)) {
            criteria.andEqualTo("phone", commonName);
        }
    }

    /**
	 * 创建
	 */
	public UserVo saveUser(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		int result = userMapper.insertSelective(user);
		if(result == 1) {
            userVo.setUserId(user.getUserId());
            saveUserRole(userVo);
            userVo = findUserById(user.getUserId());
            return userVo;
        } else {
		    return null;
        }
	}

    /**
     * 更新
     */
    public UserVo updateUser(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 1) {
            if(userVo.getRoleVoList() != null) {
                userRoleService.deleteUserRoleByUserId(userVo.getUserId());
            }
            saveUserRole(userVo);
            userVo = findUserById(user.getUserId());
            return userVo;
        } else {
            return null;
        }
    }

    /**
     * 保存用户与角色的关系
     */
    private void saveUserRole(UserVo userVo) {
        if(userVo.getRoleVoList() != null && !userVo.getRoleVoList().isEmpty()) {
            List<UserRole> userRoleList = new ArrayList();
            for(RoleVo roleVo: userVo.getRoleVoList()) {
                UserRole userRole = new UserRole(userVo.getUserId(), roleVo.getRoleId(), StatusEnum.ENABLED.getStatus());
                userRoleList.add(userRole);
            }
            userRoleService.save(userRoleList);
        }
    }

    /**
     * 更新密码
     */
    public Boolean updatePassword(UserVo userVo) {
        Boolean flag = false;
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * 更新验证码状态
     */
    public Boolean updateCaptchaStatus(UserVo userVo) {
        Boolean flag = false;
        User user = new User();
        user.setUserId(userVo.getUserId());
        user.setCaptchaStatus(userVo.getCaptchaStatus());
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * 更新重置密码状态
     */
    public Boolean updateResetStatus(UserVo userVo) {
        Boolean flag = false;
        User user = new User();
        user.setUserId(userVo.getUserId());
        user.setResetStatus(userVo.getResetStatus());
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * 根据OrgId查询User
     */
    public List<UserVo> findUserByOrgId(UserVo userVo) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("orgId",userVo.getOrgId());
        map.put("status",userVo.getStatus());
        return userMapper.selectUserVoByOrgId(map);
    }

    /**
     * 判断用户名、邮箱、手机号是否已注册
     * true:存在，false：不存在
     */
    public Boolean isExistedUser(UserVo userVo) {
        Boolean flag = false;
        Condition condition = new Condition(User.class);
        Condition.Criteria criteria = condition.createCriteria();
        if(userVo.getUsername() != null) {
            criteria.andEqualTo("username", userVo.getUsername());
        }
        if(userVo.getEmail() != null) {
            criteria.andEqualTo("email", userVo.getEmail());
        }
        if(userVo.getPhone() != null) {
            criteria.andEqualTo("phone", userVo.getPhone());
        }
        int size = userMapper.selectCountByCondition(condition);
        if (size > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 删除用户
     * 逻辑删除
     */
    public Integer deleteUser(Long userId){
        User user = new User();
        user.setUserId(userId);
        user.setStatus(StatusEnum.DELETED.toString());
//        Condition condition = new Condition(User.class);
//        Condition.Criteria criteria = condition.createCriteria();
//        if(userId != null){
//            criteria.andEqualTo("userId",userId);
//        }
//        criteria.andEqualTo("status",StatusEnum.DELETED);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
