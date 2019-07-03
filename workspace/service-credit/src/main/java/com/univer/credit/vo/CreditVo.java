package com.univer.credit.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.univer.credit.po.Credit;
import org.springframework.stereotype.Component;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-19 17:58
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class CreditVo extends Credit {

}

