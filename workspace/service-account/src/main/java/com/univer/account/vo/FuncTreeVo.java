package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.Func;

import java.util.ArrayList;
import java.util.List;
/**
 * 功能树返回类
 * @author hongjiao
 */
@JsonInclude(Include.NON_NULL)
public class FuncTreeVo implements Comparable<FuncTreeVo> {

	private Func func;

	private List<FuncTreeVo> children;

	public FuncTreeVo() {
		super();
		func = new Func();
		func.setFuncId(0L);
		children = new ArrayList<FuncTreeVo>();
	}

	public Func getFunc() {
		return func;
	}

	public void setFunc(Func func) {
		this.func = func;
	}

	public List<FuncTreeVo> getChildren() {
		return children;
	}

	public void setChildren(List<FuncTreeVo> children) {
		this.children = children;
	}

	@Override
	public int compareTo(FuncTreeVo temp) {
		return this.func.getNumber().compareTo(temp.getFunc().getNumber());
	}

}
