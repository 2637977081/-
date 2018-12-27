package com.univer.course.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.univer.course.po.Teach;
import org.springframework.stereotype.Component;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-21 11:46
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class TeachVo extends Teach {
}
