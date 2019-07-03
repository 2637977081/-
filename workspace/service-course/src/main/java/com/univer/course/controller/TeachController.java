package com.univer.course.controller;

import com.github.pagehelper.PageInfo;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.UUIDUtil;
import com.univer.base.util.VoUtils;
import com.univer.course.constant.MsgConstant;
import com.univer.course.enums.TeachTypeEnum;
import com.univer.course.po.Lesson;
import com.univer.course.po.Teach;
import com.univer.course.service.CourseService;
import com.univer.course.service.LessonService;
import com.univer.course.service.TeachService;
import com.univer.course.vo.TeachVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-21 10:20
 */
@RestController
@RequestMapping("teach")
@Scope("prototype")
public class TeachController extends AuthorizationController<Object> {

    @Autowired
    private TeachVo teachVo;

    @Autowired
    private TeachService teachService;

    @PostMapping("add/teach")
    public Object addTeach(@RequestBody  List<Teach> temp){
        List<Teach> teaches = new ArrayList<>();
        for (Teach teach:temp){
            if(!teachService.isExisted(teach.getStudentId(),teach.getLessonId())){
                teach.setCode(UUIDUtil.getUUID());
                teach.setType(TeachTypeEnum.TEACHING.toString());
                teach.setBehavior(0);
                teach.setTest(0);
                teach.setExam(0);
                teach.setScore(0);
                teach.setCredit(0);
                teach.setCreateId(loginUser.getUserId());
                teach.setCreateTime(new Date());
                teach.setStatus(StatusEnum.ENABLED.toString());
                teaches.add(teach);
            }
        }
        List<Teach> list = teachService.addTeach(teaches);
        if(list.size()>0){
            resultVo.getInstance(HttpStatus.OK.toString(),list);
        }else {
            resultVo.getInstance(MsgConstant.NO_DATA);
        }
        return resultVo;
    }

    @PostMapping("get/teach")
    public Object getTeach(@RequestBody Teach temp){
        Teach teach = new Teach();
        teach.setStudentId(temp.getStudentId());
        teach.setLessonId(temp.getLessonId());
        if(!teachService.isExisted(temp.getStudentId(),temp.getLessonId())){
            teach.setCode(UUIDUtil.getUUID());
            teach.setType(TeachTypeEnum.TEACHING.toString());
            teach.setName("班级"+temp.getLessonId());
            teach.setBehavior(0);
            teach.setTest(0);
            teach.setExam(0);
            teach.setScore(0);
            teach.setCredit(0);
            teach.setCreateId(loginUser.getUserId());
            teach.setCreateTime(new Date());
            teach.setStatus(StatusEnum.ENABLED.toString());
            teachService.getTeach(teach);
            if(teach!=null){
                resultVo.getInstance(HttpStatus.OK.toString(),teach);
            }else {
                resultVo.getInstance(MsgConstant.NO_DATA);
            }
        }else {
            resultVo.getInstance(MsgConstant.COURSE_EXISTED);
        }
        return resultVo;
    }

    @GetMapping("delete/{id}")
    public Object delete(@PathVariable Long id){
        TeachVo teachVo = new TeachVo();
        teachVo.setTeachId(id);
        teachVo.setUpdateTime(new Date());
        teachVo.setStatus(StatusEnum.DISABLED.toString());
        Boolean bool = teachService.updateTeach(teachVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("enable/{id}")
    public Object enable(@PathVariable Long id){
        TeachVo teachVo = new TeachVo();
        teachVo.setTeachId(id);
        teachVo.setUpdateTime(new Date());
        teachVo.setStatus(StatusEnum.ENABLED.toString());
        Boolean bool = teachService.updateTeach(teachVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @PostMapping("/update")
    public Object update(@RequestBody TeachVo temp) throws Exception{
        VoUtils.copyProperties(temp, teachVo,"teachId","name","type","studentId","studentName","behavior","test","exam","credit","score");
        teachVo.setUpdateTime(new Date());
        Boolean bool = teachService.updateTeach(teachVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("detail/{id}")
    public Object detail(@PathVariable Long id){
        Teach teach = teachService.detail(id);
        return resultVo.getInstance(HttpStatus.OK.toString(),teach);
    }

    @GetMapping("list")
    public Object list(TeachVo temp) throws Exception {
        VoUtils.copyProperties(temp, teachVo,"teacherId","name","type","studentId","teacherId","teacherName","behavior","test","exam","credit","teachTime", "page", "rows");
        List<Teach> list = teachService.findByPage(teachVo);
        PageInfo<Teach> pageInfo = new PageInfo<Teach>(list);
        resultVo.getInstance(HttpStatus.OK.toString(), pageInfo);
        return resultVo;
    }

}
