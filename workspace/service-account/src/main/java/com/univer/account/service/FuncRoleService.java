package com.univer.account.service;

import com.github.pagehelper.PageHelper;
import com.univer.account.mapper.FuncRoleMapper;
import com.univer.account.po.FuncRole;
import com.univer.account.vo.FuncRoleVo;
import com.univer.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * 功能角色中间表业务层
 * @author hongjiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FuncRoleService extends BaseService<FuncRole> {

	private static final Logger log = LoggerFactory.getLogger(FuncRoleService.class);

	@Autowired
	private FuncRoleMapper funcRoleMapper;

	/**
	 * 分页查询
	 */
	public List<FuncRoleVo> findByPage(FuncRoleVo funcRoleVo) {
		if (funcRoleVo.getPage() != null && funcRoleVo.getRows() != null) {
			PageHelper.startPage(funcRoleVo.getPage(), funcRoleVo.getRows());
		}
		return null;
	}

	/**
	 * 查询用户信息
	 */
	public FuncRoleVo findFuncRoleById(Long id) {
		FuncRoleVo funcRoleVo = null;
		FuncRole funcRole = funcRoleMapper.selectByPrimaryKey(id);
		if(funcRole != null) {
            funcRoleVo = new FuncRoleVo();
            BeanUtils.copyProperties(funcRole, funcRoleVo);
        }
		return funcRoleVo;
	}

	/**
	 * 创建
	 */
	public FuncRoleVo saveFuncRole(FuncRoleVo funcRoleVo) {
		FuncRole funcRole = new FuncRole();
		BeanUtils.copyProperties(funcRoleVo, funcRole);
        funcRoleVo = null;
		int result = funcRoleMapper.insertSelective(funcRole);
		if(result == 1) {
            funcRoleVo = findFuncRoleById(funcRole.getFuncRoleId());
        }
        return funcRoleVo;
	}

    /**
     * 更新
     */
    public FuncRoleVo updateFuncRole(FuncRoleVo funcRoleVo) {
        FuncRole funcRole = new FuncRole();
        BeanUtils.copyProperties(funcRoleVo, funcRole);
        funcRoleVo = null;
        int result = funcRoleMapper.updateByPrimaryKeySelective(funcRole);
        if(result == 1) {
            funcRoleVo = findFuncRoleById(funcRole.getFuncRoleId());
        }
        return funcRoleVo;
    }

	/**
	 * 根据角色ID删除
	 */
	public void deleteFuncRoleByRoleId(Long roleId) {
		Condition condition = new Condition(FuncRole.class);
		Condition.Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("roleId", roleId);
		funcRoleMapper.deleteByCondition(condition);
	}

}
