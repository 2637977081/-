package com.univer.account.controller;

import com.univer.account.po.Func;
import com.univer.account.service.FuncService;
import com.univer.account.validation.FuncAdd;
import com.univer.account.validation.FuncUpdate;
import com.univer.account.vo.FuncTreeVo;
import com.univer.account.vo.FuncVo;
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
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * 功能表相关功能控制层
 * @author hongjiao
 */
@RestController
@RequestMapping("/func/")
@Scope("prototype")
public class FuncController extends AuthorizationController<Object> {

	private static final Logger logger = LoggerFactory.getLogger(FuncController.class);

	@Autowired
	private FuncService funcService;
	@Autowired
	private FuncVo funcVo;

	/** 
     * 树形列表查询
     */
	@GetMapping("list/{funcId}")
	public ResultVo list(@PathVariable Long funcId ) {
		FuncTreeVo funcTreeVo = funcService.getFuncTreeById(funcId);
		resultVo.getInstance(HttpStatus.OK.toString(), funcTreeVo);
		return resultVo;
	}

	/**
	 * 系统树形列表查询
	 */
	@GetMapping("systems/ids")
	public ResultVo list(Long[] ids ) {
		FuncTreeVo funcTreeVo = null;
		if (ids != null && ids.length > 0){
			Condition condition = new Condition(Func.class);
			condition.createCriteria().andEqualTo("parentId",0L);
			List<Func> funcList = funcService.findByCondition(condition);
			if (funcList != null && funcList.size() > 0){
				funcTreeVo = new FuncTreeVo();
				Func func = funcList.get(0);
				funcTreeVo.setFunc(func);
				FuncTreeVo childTree = null;
				for (Long funcId: ids) {
					childTree = funcService.getFuncTreeById(funcId);
					funcTreeVo.getChildren().add(childTree);
				}
			}
		}
		resultVo.getInstance(HttpStatus.OK.toString(), funcTreeVo);
		return resultVo;
	}
	
	/** 
     * 查询详情
     */
	@GetMapping("detail/{funcId}")
	public ResultVo detail(@PathVariable Long funcId) {
		FuncVo funcVo = funcService.findFuncById(funcId);
		if(funcVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), funcVo);
        } else {
            resultVo.getInstance(MsgConstant.NO_DATA, funcVo);
        }
		return resultVo;
	}
	
	/** 
     * 创建
     */
	@PostMapping("add")
	public ResultVo add(@RequestBody @Validated( {FuncAdd.class }) FuncVo temp)throws Exception {
		VoUtils.copyProperties(temp, funcVo,"name","description","url","icon","type","parentId","code","status");
		// 检验状态值是否符合
		if (StatusEnum.getStatus(funcVo.getStatus()) == null){
			resultVo.getInstance(MsgConstant.INVALID_DATA);
			return resultVo;
		}
		// 检查该父级是否存在
        Func func = funcService.findFuncById(funcVo.getParentId());
		if (func == null){
			resultVo.getInstance(MsgConstant.NO_DATA);
			return resultVo;
		}
        funcVo.setRootId(func.getRootId());
		funcVo.setCode(UUIDUtil.getUUID());
		funcVo = funcService.saveFunc(funcVo);
		if (funcVo != null) {
			resultVo.getInstance(HttpStatus.OK.toString(), funcVo);
		} else {
			resultVo.getInstance(MsgConstant.CREATE_ERROR, funcVo);
		}
		return resultVo;
	}
	
	/** 
     * 更新
     */
	@PostMapping("update")
	public ResultVo update(@RequestBody @Validated( {FuncUpdate.class }) FuncVo temp) throws Exception {
		VoUtils.copyProperties(temp , funcVo,"funcId","name","description","url","icon","type","status");
		// 检验状态值是否符合
		if (!StringUtils.isEmpty(funcVo.getStatus()) && StatusEnum.getStatus(funcVo.getStatus())== null){
			resultVo.getInstance(MsgConstant.INVALID_DATA);
			return resultVo;
		}
		// 检验父级是否存在
		if (funcVo.getParentId() != null && !funcService.isExistedFunc(funcVo.getParentId())){
			resultVo.getInstance(MsgConstant.NO_DATA);
			return resultVo;
		}
        funcVo = funcService.updateFunc(funcVo);
        if (funcVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), funcVo);
        } else {
            resultVo.getInstance(MsgConstant.UPDATE_ERROR, funcVo);
        }
		return resultVo;
	}

	/** 
     * 删除
     */
	@DeleteMapping("delete/{funcId}")
	public ResultVo delete(@PathVariable Long funcId) {
		String code = funcService.deleteFuncById(funcId);
		resultVo.getInstance(code);
		return resultVo;
	}

	/** 
     * 批量删除
     */
//	@DeleteMapping("deleteList")
//	public Object delete(@RequestParam(defaultValue = "") String ids) {
//		int num = funcService.deleteByIds(ids);
//		if (num > 0) {
//            resultVo.getInstance(HttpStatus.OK.toString());
//		}
//		return resultVo;
//	}

}