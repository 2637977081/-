package com.univer.account.controller;

import com.univer.account.po.Dict;
import com.univer.account.service.DictService;
import com.univer.account.validation.DictAdd;
import com.univer.account.validation.DictUpdate;
import com.univer.account.vo.DictVo;
import com.univer.base.constant.MsgConstant;
import com.univer.base.controller.BaseController;
import com.univer.base.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 字典相关功能
 * @author hongjiao
 */
@RestController
@RequestMapping("/dict/")
@Scope("prototype")
public class DictController extends BaseController<Object> {

	private static final Logger logger = LoggerFactory.getLogger(DictController.class);

	@Autowired
	private DictService dictService;

	/** 
     * 列表查询
     */
	@GetMapping("list/{type}")
	public ResultVo list(@PathVariable String type) {
		List<Dict> list = dictService.findDictByType(type);
		resultVo.getInstance(HttpStatus.OK.toString(), list);
		return resultVo;
	}

	/**
	* @description: 根据type值返回一个map对象
	* @author:lvgang
	* @date: 2018/10/16 11:37
	**/
	@GetMapping("map/{type}")
	public ResultVo map(@PathVariable String type){
		Map<String,String> map = dictService.findMapByType(type);
		resultVo.getInstance(HttpStatus.OK.toString(),map);
		return resultVo;
	}

	/** 
     * 查询详情
     */
	@GetMapping("detail/{id}")
	public ResultVo detail(@PathVariable Long id) {
		DictVo dictVo = dictService.findDictById(id);
		if(dictVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), dictVo);
        } else {
            resultVo.getInstance(MsgConstant.NO_DATA, dictVo);
        }
		return resultVo;
	}
	
	/** 
     * 创建
     */
	@PostMapping("add")
	public ResultVo add(@RequestBody @Validated( {DictAdd.class }) DictVo dictVo) {
        dictVo = dictService.saveDict(dictVo);
		if (dictVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), dictVo);
		} else {
            resultVo.getInstance(MsgConstant.CREATE_ERROR, dictVo);
        }
		return resultVo;
	}
	
	/** 
     * 更新
     */
	@PostMapping("update")
	public ResultVo update(@RequestBody @Validated( {DictUpdate.class }) DictVo dictVo) {
        dictVo = dictService.updateDict(dictVo);
        if (dictVo != null) {
            resultVo.getInstance(HttpStatus.OK.toString(), dictVo);
        } else {
            resultVo.getInstance(MsgConstant.UPDATE_ERROR, dictVo);
        }
		return resultVo;
	}

	/** 
     * 删除
     */
	@DeleteMapping("delete/{id}")
	public ResultVo delete(@PathVariable Long id) {
		int num = dictService.deleteById(id);
		if (num == 1) {
            resultVo.getInstance(HttpStatus.OK.toString());
		}
		return resultVo;
	}

}