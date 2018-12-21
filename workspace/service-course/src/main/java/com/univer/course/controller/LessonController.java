package com.univer.course.controller;

import com.univer.base.controller.AuthorizationController;
import com.univer.course.po.Lesson;
import com.univer.course.service.LessonService;
import com.univer.course.vo.LessonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 16:08
 */
@RestController
@RequestMapping("/lesson")
@Scope("prototype")
public class LessonController extends AuthorizationController<Object> {

    @Autowired
    private LessonVo lessonVo;

    @Autowired
    private LessonService lessonService;

    @PostMapping("add/lesson")
    public Object addLesson(@RequestBody List<Lesson> temp){
        Integer result = lessonService.addLesson(temp);
        return resultVo;
    }
}
