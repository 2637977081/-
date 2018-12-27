package com.univer.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.univer.account.po.Dict;
import org.springframework.stereotype.Component;

/**
 * 字典表返回类
 * @author hongjiao
 */
@JsonInclude(Include.NON_NULL)
@Component
public class DictVo extends Dict {

}
