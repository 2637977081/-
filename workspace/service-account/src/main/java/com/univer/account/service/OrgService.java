package com.univer.account.service;

import com.univer.account.constant.MsgConstant;
import com.univer.account.mapper.OrgMapper;
import com.univer.account.po.Org;
import com.univer.account.vo.OrgTreeVo;
import com.univer.account.vo.OrgVo;
import com.univer.account.vo.UserVo;
import com.univer.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 组织机构表业务层
 * @author hongjiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrgService extends BaseService<Org> {

	private static final Logger log = LoggerFactory.getLogger(OrgService.class);

	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private UserService userService;


	/**
	 * 获取整个树
	 */
	public OrgTreeVo getOrgTreeById(Long id) {
		OrgTreeVo orgTreeVo = null;
		Condition condition = new Condition(Org.class);
		condition.createCriteria().andEqualTo("orgId",id);
		List<Org> orgList = orgMapper.selectByCondition(condition);
		if(orgList != null ) {
			orgTreeVo = new OrgTreeVo();
			orgTreeVo.setOrg(orgList.get(0));
			getChildren(orgTreeVo,findAllByRootId(orgTreeVo.getOrg().getRootId()));
		} else {
			log.warn("Org existed multiple top nodes");
		}
		return orgTreeVo;
	}

	/**
	 * 获取所有子节点
	 */
	private void getChildren(OrgTreeVo orgTreeVo, List<Org> orgList) {
		Org parent = orgTreeVo.getOrg();
		List<OrgTreeVo> children = orgTreeVo.getChildren();
		for (Org org : orgList) {
			if(org.getParentId().equals(parent.getOrgId())) {
				OrgTreeVo child = new OrgTreeVo();
				child.setOrg(org);
				children.add(child);
				getChildren(child, orgList);
			}
		}
		Collections.sort(children);
	}
	/**
	 * 获取所在机构的顶级机构
	 */
	public Org getTopParent(Org org) {
		Org topParent = org;
		if(org != null && org.getParentId() != 0) {
			topParent = orgMapper.selectByPrimaryKey(org.getParentId());
			getTopParent(topParent);
		}
		return topParent;
	}

	public List<Org> findAllByRootId(Long rootId) {
		Condition condition = new Condition(Org.class);
		condition.createCriteria().andEqualTo("rootId",rootId);
		return orgMapper.selectByCondition(condition);
	}

	/**
	 * 查询用户信息
	 */
	public OrgVo findOrgById(Long id) {
		OrgVo orgVo = null;
		Org org = orgMapper.selectByPrimaryKey(id);
		if(org != null) {
            orgVo = new OrgVo();
            BeanUtils.copyProperties(org, orgVo);
            // 查询上级机构树
			getAllParents(orgVo);
        }
		return orgVo;
	}

	/**
	 * 获取父级树形
	 * @param orgVo
	 */
	public void getAllParents(OrgVo orgVo){
		Org org = findById(orgVo.getParentId());
		if (org != null){
			OrgVo parent = new OrgVo();
			BeanUtils.copyProperties(org, parent);
			orgVo.setParent(parent);
			getAllParents(parent);
		}
	}

	/**
	 * 创建
	 */
	public OrgVo saveOrg(OrgVo orgVo) throws Exception{
		Org org = new Org();
		BeanUtils.copyProperties(orgVo,org);
		Long orgId = orgMapper.selectMaxNumber(orgVo.getParentId());
		if(orgId == null) {
			org.setOrgId(Long.valueOf(orgVo.getParentId()+"01"));
		} else {
			org.setOrgId(orgId + 1);
		}
		orgVo = null;
		int result = orgMapper.insertSelective(org);
		if(result == 1) {
            orgVo = findOrgById(org.getOrgId());
        }
        return orgVo;
	}

    /**
     * 更新
     */
    public OrgVo updateOrg(OrgVo orgVo) throws Exception{
		Org org = new Org();
		BeanUtils.copyProperties(orgVo, org);
		orgVo = null;
		int result = orgMapper.updateByPrimaryKeySelective(org);
        if(result == 1) {
            orgVo = findOrgById(org.getOrgId());
        }
        return orgVo;
    }
	/**
	 * 删除
	 */
	public String deleteOrgById(Long id) {
		Org org = orgMapper.selectByPrimaryKey(id);
		if(org != null) {
//			// orgId=rootId 说明是顶级公司，未预置数据，不可删除
//			if (org.getOrgId().longValue() == org.getRootId().longValue()){
//				return com.univer.base.constant.MsgConstant.INVALID_OPERATION;
//			}
//			UserVo userVo = new UserVo();
//			userVo.setOrgId(id);
//			List<UserVo> userList = userService.findUserByOrgId(userVo);
//			if(userList == null || userList.isEmpty()) {
//				Condition condition = new Condition(Org.class);
//				Condition.Criteria criteria = condition.createCriteria();
//				criteria.andEqualTo("parentId", org.getOrgId());
//				Integer count = orgMapper.selectCountByCondition(condition);
//				// 如果该机构下没有子机构且没有用户，则可以删除
//				if(count == 0) {
					orgMapper.deleteByPrimaryKey(id);
					return HttpStatus.OK.toString();
//				} else {
//					return MsgConstant.ORG_EXISTED_SUBORG;
//				}
//			} else {
//				return MsgConstant.ORG_EXISTED_USER;
//			}
		} else {
			return com.univer.base.constant.MsgConstant.NO_DATA;
		}
	}

	/**
	 * 同级顺序置换
	 */
	public String exchangeOrg(Long orgId0, Long orgId1){
		Org org0 = orgMapper.selectByPrimaryKey(orgId0);
		Org org1 = orgMapper.selectByPrimaryKey(orgId1);
		if (org0 != null && org1 !=null && org0.getParentId().equals(org1.getParentId())){
			Org first = new Org();
			Org second = new Org();
			first.setOrgId(orgId0);
			second.setOrgId(orgId1);
			first.setNumber(org1.getNumber());
			second.setNumber(org0.getNumber());
			if(orgMapper.updateByPrimaryKeySelective(first)==1 && orgMapper.updateByPrimaryKeySelective(second)==1){
				return HttpStatus.OK.toString();
			}else{
				return com.univer.base.constant.MsgConstant.UPDATE_ERROR;
			}
		}
		return com.univer.base.constant.MsgConstant.NO_DATA;
	}

	/**
	 * 条件查询
	 * @param orgId
	 * @param name
	 * @param parentId
	 * @param status
	 * @return
	 */
	public List<OrgVo> selectByOrg(Long orgId, String name, Long parentId, String status,String likeName){
		HashMap<String,Object> map = new HashMap<String,Object>(16);
		map.put("orgId",orgId);
		map.put("name",name);
		map.put("parentId",parentId);
		map.put("status",status);
		map.put("likeName",likeName);
		return orgMapper.selectByMap(map);
	}

	/**
	 * 检查父级是否在子级中（防止树形结构查询的死循环）
	 * @param orgId
	 * @param parentId
	 * @return
	 */
	public boolean checkParent(Long orgId, Long parentId){
		boolean flag = false;
        List<Long> parentIds = orgMapper.selectParentIds(parentId);
		if (parentIds != null && parentIds.indexOf(orgId.longValue()) != -1){
			flag = true;
		}
		return flag;
	}
}
