package com.univer.account.controller;

import com.univer.account.po.Org;
import com.univer.account.service.OrgService;
import com.univer.account.validation.OrgAdd;
import com.univer.account.validation.OrgUpdate;
import com.univer.account.vo.OrgTreeVo;
import com.univer.account.vo.OrgVo;
import com.univer.base.constant.MsgConstant;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.UUIDUtil;
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
 * 组织机构相关功能控制层
 * @author hongjiao
 */
@RestController
@RequestMapping("/org/")
@Scope("prototype")
public class OrgController extends AuthorizationController<Object> {

	private static final Logger logger = LoggerFactory.getLogger(OrgController.class);

	@Autowired
	private OrgService orgService;
	@Autowired
	private OrgVo orgVo;

	/** 
     * 查询用户所在的组织机构树
     */
	@GetMapping("list")
	public ResultVo list() {
//		Org org = orgService.findOrgById(loginUser.getOrgId());
//		if (org == null){
//			resultVo.getInstance(MsgConstant.NO_DATA);
//			return resultVo;
//		}
		OrgTreeVo orgTreeVo = orgService.getOrgTreeById(Long.valueOf(1));
		resultVo.getInstance(HttpStatus.OK.toString(), orgTreeVo);
		return resultVo;
	}

	@GetMapping("list/org")
	public ResultVo orgList(){
		List<Org> list = orgService.findAll();
		return resultVo.getInstance(HttpStatus.OK.toString(),list);
	}

	/**
     * 查询详情
     */
	@GetMapping("detail/{orgId}")
	public ResultVo detail(@PathVariable Long orgId) {
		OrgVo orgVo = orgService.findOrgById(orgId);
		if(orgVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), orgVo);
        } else {
            resultVo.getInstance(MsgConstant.NO_DATA, orgVo);
        }
		return resultVo;
	}

	/** 
     * 创建
     */
	@PostMapping("add")
	public ResultVo add(@RequestBody @Validated( {OrgAdd.class }) OrgVo temp)throws Exception {
		VoUtils.copyProperties(temp, orgVo,"code","name","type","description","parentId","status");
		// 检验状态值是否符合
//        if (StatusEnum.getStatus(orgVo.getStatus()) == null){
//            resultVo.getInstance(MsgConstant.INVALID_DATA);
//            return resultVo;
//        }
		// 检查该父级是否存在
		if (orgService.findById(orgVo.getParentId()) == null && orgVo.getParentId()!=0){
			resultVo.getInstance(MsgConstant.NO_DATA);
			return resultVo;
		}
		// 检查该级别下是否存在同一名称
		List<OrgVo> list = orgService.selectByOrg(null,orgVo.getName(),orgVo.getParentId(),null,null);
		if (list != null && list.size() > 0){
			resultVo.getInstance(com.univer.account.constant.MsgConstant.ORG_EXISTED);
			return resultVo;
		}
		orgVo.setCreaterId(loginUser.getUserId());
        orgVo.setCode(UUIDUtil.getUUID());
		Org org = orgService.findById(loginUser.getOrgId());
        orgVo.setRootId(org.getRootId());
        orgVo = orgService.saveOrg(orgVo);
		if (orgVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), orgVo);
		} else {
            resultVo.getInstance(MsgConstant.CREATE_ERROR, orgVo);
        }
		return resultVo;
	}
	
	/** 
     * 更新
     */
	@PostMapping("update")
	public ResultVo update(@RequestBody @Validated( {OrgUpdate.class }) OrgVo temp) throws Exception{
		VoUtils.copyProperties(temp, orgVo,"orgId","name","type","description","parentId","status");
		// 检验状态值是否符合
		if (!StringUtils.isEmpty(orgVo.getStatus()) && StatusEnum.getStatus(orgVo.getStatus())== null){
			resultVo.getInstance(MsgConstant.INVALID_DATA);
			return resultVo;
		}
		// 检查该级别下是否存在同一名称
		if (orgVo.getName() != null) {
			List<OrgVo> list = orgService.selectByOrg(null,orgVo.getName(),orgVo.getParentId(),null,null);
			if (list != null && list.size() > 0){
				Org org = list.get(0);
				if (org.getOrgId().longValue() != orgVo.getOrgId().longValue()) {
					resultVo.getInstance(com.univer.account.constant.MsgConstant.ORG_EXISTED);
					return resultVo;
				}
			}
		}
//		// 检验父级是否存在
//		if (orgVo.getParentId() != null){
//			Org org = orgService.findById(orgVo.getOrgId());
//			Org parent = orgService.findById(orgVo.getParentId());
//			if (parent == null || org == null || !parent.getRootId().equals(org.getRootId())) {
//				resultVo.getInstance(MsgConstant.INVALID_DATA);
//				return resultVo;
//			}
//			if (orgService.checkParent(orgVo.getOrgId(),orgVo.getParentId())){
//				resultVo.getInstance(com.univer.account.constant.MsgConstant.ORG_TARGET_ERROR);
//				return resultVo;
//			}
//		}
        orgVo = orgService.updateOrg(orgVo);
        if (orgVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), orgVo);
        } else {
            resultVo.getInstance(MsgConstant.UPDATE_ERROR, orgVo);
        }
		return resultVo;
	}

	/** 
     * 删除
     */
	@DeleteMapping("delete/{orgId}")
	public ResultVo delete(@PathVariable Long orgId) {
		String code = orgService.deleteOrgById(orgId);
		resultVo.getInstance(code);
		return resultVo;
	}

	/** 
     * 批量删除
     */

	/** @DeleteMapping("deleteList") */
	public ResultVo delete(@RequestParam(defaultValue = "") String ids) {
		int num = orgService.deleteByIds(ids);
		if (num > 0) {
            resultVo.getInstance(HttpStatus.OK.toString());
		}
		return resultVo;
	}

	/**
	 * 同级顺序置换
	 */
	@PostMapping("exchange/{id1}/{id2}")
	public ResultVo exchange(@PathVariable Long id1, @PathVariable Long id2) throws Exception{
		String code = orgService.exchangeOrg(id1, id2);
		resultVo.getInstance(code);
		return resultVo;
	}

}