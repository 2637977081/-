package com.univer.course.controller;

import com.github.pagehelper.PageInfo;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.UUIDUtil;
import com.univer.base.util.VoUtils;
import com.univer.base.vo.ResultVo;
import com.univer.course.constant.MsgConstant;
import com.univer.course.po.Course;
import com.univer.course.service.CourseService;
import com.univer.course.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-19 19:53
 */
@RestController
@RequestMapping("/course")
@Scope("prototype")
public class CourseController extends AuthorizationController<Object> {

    @Autowired
    private CourseVo courseVo;

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody CourseVo temp) throws Exception{
        VoUtils.copyProperties(temp, courseVo,"name","type","universityId","universityName","facultyId","facultyName","subjectId","subjectName");
        if(courseService.isExistedCourse(courseVo)){
            resultVo.getInstance(MsgConstant.COURSE_EXISTED);
        }else {
            courseVo.setCode(UUIDUtil.getUUID());
            courseVo.setCreateId(loginUser.getUserId());
            courseVo.setCreateTime(new Date());
        }
        courseVo = courseService.saveCourse(courseVo);
        if(courseVo!=null){
            resultVo.getInstance(HttpStatus.OK.toString(),courseVo);
        }else {
            resultVo.getInstance(MsgConstant.CREATE_ERROR);
        }
        return resultVo;
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody CourseVo temp) throws Exception{
        VoUtils.copyProperties(temp, courseVo,"courseId","name","type","universityId","universityName","facultyId","facultyName","subjectId","subjectName");
        courseVo.setUpdateTime(new Date());
        Boolean bool = courseService.updateCourse(courseVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("/delete/{id}")
    public ResultVo delete(@PathVariable Long id){
        CourseVo courseVo = new CourseVo();
        courseVo.setCourseId(id);
        courseVo.setUpdateTime(new Date());
        courseVo.setStatus(StatusEnum.DISABLED.toString());
        Boolean bool = courseService.updateCourse(courseVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("/detail/{id}")
    public ResultVo detail(@PathVariable Long id){
        CourseVo courseVo = courseService.detail(id);
        if(courseVo!=null){
            resultVo.getInstance(HttpStatus.OK.toString(),courseVo);
        }else {
            resultVo.getInstance(MsgConstant.NO_DATA);
        }
        return resultVo;
    }

    @GetMapping("list")
    public ResultVo list(CourseVo temp) throws Exception {
        VoUtils.copyProperties(temp, courseVo, "name","type","universityId","universityName","facultyId","facultyName","subjectId","subjectName", "page", "rows");
        List<Course> list = courseService.findByPage(courseVo);
        PageInfo<Course> pageInfo = new PageInfo<Course>(list);
        resultVo.getInstance(HttpStatus.OK.toString(), pageInfo);
        return resultVo;
    }
}
