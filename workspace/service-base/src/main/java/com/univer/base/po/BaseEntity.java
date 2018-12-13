package com.univer.base.po;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author guwei
 *
 * 基础信息
 */
public class BaseEntity {

	@JsonInclude(Include.NON_NULL)
	@Transient
    private Integer page;

	@JsonInclude(Include.NON_NULL)
    @Transient
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

}
