package com.univer.course.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.univer.course.po.Course;
import org.springframework.stereotype.Component;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-19 19:56
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class CourseVo extends Course {

}
