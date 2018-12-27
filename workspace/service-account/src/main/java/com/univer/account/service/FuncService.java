package com.univer.account.service;

import com.github.pagehelper.PageHelper;
import com.univer.account.constant.MsgConstant;
import com.univer.account.mapper.FuncMapper;
import com.univer.account.mapper.RoleMapper;
import com.univer.account.po.Func;
import com.univer.account.vo.FuncTreeVo;
import com.univer.account.vo.FuncVo;
import com.univer.account.vo.UserVo;
import com.univer.base.constant.RoleConstant;
import com.univer.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.*;

/**
 * 功能表业务层
 * @author hongjiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FuncService extends BaseService<Func> {

	private static final Logger log = LoggerFactory.getLogger(FuncService.class);

	@Autowired
	private FuncMapper funcMapper;
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 分页查询
	 */
	public List<FuncVo> findByPage(FuncVo funcVo) {
		if (funcVo.getPage() != null && funcVo.getRows() != null) {
			PageHelper.startPage(funcVo.getPage(), funcVo.getRows());
		}
		return null;
	}
	/**
	 * 根据用户获取功能列表
	 */
	public List<Func> getFuncByUserId(Long userId,String status) {
		return funcMapper.getFuncByUserId(userId,status);
	}

	/**
	 * 根据用户获取功能列表
	 */
	public List<FuncVo> getFuncVoByUserId(Long userId,String status) {
		List<FuncVo> funcVoList = null;
		int roleCount = roleMapper.countByCodeAndUserId(RoleConstant.SUPER, userId);
		if (roleCount == 1){
			funcVoList = funcMapper.getFuncVoByUserId(null,status);
		}else {
			funcVoList = funcMapper.getFuncVoByUserId(userId,status);
		}
		return funcVoList;
	}

	/**
	 * 用户的功能树形列表
	 */
	public FuncTreeVo getFuncTreeByUserId(Long userId,String status) {
		List<Func> subTreeFuncList = new ArrayList<Func>();
		Map<Long, Func> subTreeMenuMap = new HashMap<Long, Func>(16);
		// 全部func
		List<Func> allFuncList = funcMapper.getFuncByUserId(null,status);
		//该用户func
		List<Func> leafFunc = null;
		int roleCount = roleMapper.countByCodeAndUserId(RoleConstant.SUPER, userId);
		if (roleCount == 1){
			leafFunc = allFuncList;
		}else {
			leafFunc = getFuncByUserId(userId,status);
		}
		for (Func func : leafFunc) {
			subTreeMenuMap.put(func.getFuncId(), func);
			findSubTree(func, allFuncList, subTreeMenuMap);
		}
		subTreeFuncList.addAll(subTreeMenuMap.values());
		return getFuncTree(subTreeFuncList);
	}

	/**
	 * 根据叶子节点遍历出子树节点
	 */
	public void findSubTree(Func func, List<Func> allMenuList, Map<Long, Func> subTreeMenuMap) {
		Long parentId = func.getParentId();
		if(parentId != 0) {
			for (Func temp : allMenuList) {
				if(parentId.intValue() == temp.getFuncId().intValue()) {
					subTreeMenuMap.put(temp.getFuncId(), temp);
					findSubTree(temp, allMenuList, subTreeMenuMap);
					break;
				}
			}
		}
	}

	/**
	 * 根据角色ID查询功能
	 */
	public List<Func> findByRoleId(Long roleId,String status){
		return funcMapper.selectByRoleId(roleId,status);
	}

	/**
	 * 获取整个树
	 */
	public FuncTreeVo getFuncTreeById(Long funcId) {
		FuncTreeVo funcTreeVo = null;
		Func func = funcMapper.selectByPrimaryKey(funcId);
		if(func != null) {
		    funcTreeVo = new FuncTreeVo();
			funcTreeVo.setFunc(func);
            getChildren(funcTreeVo, findAllByRootId(func.getRootId()));
        } else {
            log.warn("Func existed multiple top nodes");
        }
		return funcTreeVo;
	}

	/**
	 * 获取所有子节点
	 */
	private void getChildren(FuncTreeVo funcTreeVo, List<Func> funcList) {
		Func parent = funcTreeVo.getFunc();
		List<FuncTreeVo> children = funcTreeVo.getChildren();
		for (Func func : funcList) {
			if(func.getParentId().longValue() == parent.getFuncId().longValue()) {
				FuncTreeVo child = new FuncTreeVo();
				child.setFunc(func);
				children.add(child);
				getChildren(child, funcList);
			}
		}
		Collections.sort(children);
	}

	/**
	 * 查询功能信息
	 */
	public FuncVo findFuncById(Long id) {
		FuncVo funcVo = null;
		Func func = funcMapper.selectByPrimaryKey(id);
		if(func != null) {
            funcVo = new FuncVo();
            BeanUtils.copyProperties(func, funcVo);
        }
		return funcVo;
	}

	/**
	 * 根据rootId查询列表
	 */
	public List<Func> findAllByRootId(Long rootId) {
		Condition condition = new Condition(Func.class);
		condition.createCriteria().andEqualTo("rootId",rootId);
		return funcMapper.selectByCondition(condition);
	}

	/**
	 * 查询是否存在
	 */
	public boolean isExistedFunc(Long id) {
		Func func = funcMapper.selectByPrimaryKey(id);
		if(func != null) {
			return true;
		}
		return false;
	}

	/**
	 * 创建
	 */
	public FuncVo saveFunc(FuncVo funcVo) throws Exception {
		Func func = new Func();
		BeanUtils.copyProperties(funcVo,func);
		funcVo = null;
		Long maxNumber = funcMapper.selectMaxNumber(func.getParentId());
		if(maxNumber == null) {
			func.setNumber(0L);
		} else {
			func.setNumber(maxNumber + 1);
		}
		int result = funcMapper.insertSelective(func);
		if(result == 1) {
            funcVo = findFuncById(func.getFuncId());
        }
        return funcVo;
	}

    /**
     * 更新
     */
    public FuncVo updateFunc(FuncVo funcVo) throws Exception{
        Func func = new Func();
        BeanUtils.copyProperties(funcVo, func);
        funcVo = null;
        int result = funcMapper.updateByPrimaryKeySelective(func);
        if(result == 1) {
            funcVo = findFuncById(func.getFuncId());
        }
        return funcVo;
    }

	/**
	 * 删除
	 */
	public String deleteFuncById(Long id) {
		Func func = funcMapper.selectByPrimaryKey(id);
		if(func != null) {
			UserVo userVo = new UserVo();
			userVo.setOrgId(id);
			Condition condition = new Condition(Func.class);
			Condition.Criteria criteria = condition.createCriteria();
			criteria.andEqualTo("parentId", func.getFuncId());
			Integer count = funcMapper.selectCountByCondition(condition);
			// 如果该功能下没有子功能，则可以删除
			if(count == 0) {
				funcMapper.deleteByPrimaryKey(id);
				return HttpStatus.OK.toString();
			} else {
				return MsgConstant.FUN_EXISTED_SUBFUNC;
			}
		}
		return com.univer.base.constant.MsgConstant.NO_DATA;
	}

	/**
	 * 获取菜单树形结构
	 */
	public FuncTreeVo getFuncTree(List<Func> menuList) {
		FuncTreeVo funcTreeVo = new FuncTreeVo();
		Condition condition = new Condition(Func.class);
		Condition.Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("parentId", 0);
		List<Func> tempList = funcMapper.selectByCondition(condition);
		if(tempList != null && tempList.size() == 1) {
			funcTreeVo.setFunc(tempList.get(0));
		} else {
			log.warn("func existed multiple top nodes");
		}
		getChildren(funcTreeVo, menuList);
		return funcTreeVo;
	}
}
