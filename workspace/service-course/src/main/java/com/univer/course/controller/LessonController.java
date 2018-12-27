package com.univer.course.controller;

import com.github.pagehelper.PageInfo;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.VoUtils;
import com.univer.course.constant.MsgConstant;
import com.univer.course.po.Lesson;
import com.univer.course.service.LessonService;
import com.univer.course.vo.LessonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Object addLesson(@RequestBody List<Lesson> temp,String type){
        List<Lesson> list = lessonService.addLesson(temp,type);
        if(list.size()>0){
            resultVo.getInstance(HttpStatus.OK.toString(),list);
        }else {
            resultVo.getInstance(MsgConstant.NO_DATA);
        }
        return resultVo;
    }

    @GetMapping("delete/{id}")
    public Object delete(@PathVariable Long id){
        LessonVo lessonVo = new LessonVo();
        lessonVo.setLessonId(id);
        lessonVo.setUpdateTime(new Date());
        lessonVo.setStatus(StatusEnum.DISABLED.toString());
        Boolean bool = lessonService.updateLesson(lessonVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("enable/{id}")
    public Object enable(@PathVariable Long id){
        LessonVo lessonVo = new LessonVo();
        lessonVo.setLessonId(id);
        lessonVo.setUpdateTime(new Date());
        lessonVo.setStatus(StatusEnum.ENABLED.toString());
        Boolean bool = lessonService.updateLesson(lessonVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @PostMapping("/update")
    public Object update(@RequestBody LessonVo temp) throws Exception{
        VoUtils.copyProperties(temp, lessonVo,"lessonId","name","type","teacherId","teacherName","behavior","test","exam","credit","teachTime");
        lessonVo.setUpdateTime(new Date());
        Boolean bool = lessonService.updateLesson(lessonVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("detail/{id}")
    public Object detail(@PathVariable Long id){
        Lesson lesson = lessonService.detail(id);
        return resultVo.getInstance(HttpStatus.OK.toString(),lesson);
    }

    @GetMapping("list")
    public Object list(LessonVo temp) throws Exception {
        VoUtils.copyProperties(temp, lessonVo,"lessonId","name","type","teacherId","teacherName","behavior","test","exam","credit","teachTime", "page", "rows");
        List<Lesson> list = lessonService.findByPage(lessonVo);
        PageInfo<Lesson> pageInfo = new PageInfo<Lesson>(list);
        resultVo.getInstance(HttpStatus.OK.toString(), pageInfo);
        return resultVo;
    }
}
