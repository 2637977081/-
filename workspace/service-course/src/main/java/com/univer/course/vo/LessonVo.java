package com.univer.course.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.univer.course.po.Lesson;
import org.springframework.stereotype.Component;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 16:10
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class LessonVo extends Lesson {
}
