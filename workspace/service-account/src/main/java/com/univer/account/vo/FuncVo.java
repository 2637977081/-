package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.Func;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能表返回类
 * @author hongjiao
 */
@JsonInclude(Include.NON_NULL)
@Component
@Scope("prototype")
public class FuncVo extends Func {

    /**
     * 过滤登录时的冗余字段
     */
    public static void filterFuncVoListByLogin(List<FuncVo> functionVolist) {
        for (FuncVo funcVo: functionVolist ) {
            funcVo.setDescription(null);
            funcVo.setIcon(null);
            funcVo.setType(null);
            funcVo.setNumber(null);
            funcVo.setParentId(null);
            funcVo.setStatus(null);
            funcVo.setCreateTime(null);
            funcVo.setUpdateTime(null);
        }
    }
}
