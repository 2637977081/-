package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.Org;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
/**
 * 组织机构树形返回类
 * @author hongjiao
 */
@JsonInclude(Include.NON_NULL)
@Scope("prototype")
public class OrgTreeVo implements Comparable<OrgTreeVo> {

	private Org org;

	private List<OrgTreeVo> children;

	public OrgTreeVo() {
		super();
		org = new Org();
		org.setOrgId(0L);
		children = new ArrayList<OrgTreeVo>();
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public List<OrgTreeVo> getChildren() {
		return children;
	}

	public void setChildren(List<OrgTreeVo> children) {
		this.children = children;
	}

	@Override
	public int compareTo(OrgTreeVo temp) {
		return this.org.getNumber().compareTo(temp.getOrg().getNumber());
	}

}
