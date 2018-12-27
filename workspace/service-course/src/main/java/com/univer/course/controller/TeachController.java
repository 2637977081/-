package com.univer.course.controller;

import com.github.pagehelper.PageInfo;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.VoUtils;
import com.univer.course.constant.MsgConstant;
import com.univer.course.po.Teach;
import com.univer.course.service.TeachService;
import com.univer.course.vo.TeachVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Object addTeach(@RequestBody List<Teach> temp){
        List<Teach> list = teachService.addTeach(temp);
        if(list.size()>0){
            resultVo.getInstance(HttpStatus.OK.toString(),list);
        }else {
            resultVo.getInstance(MsgConstant.NO_DATA);
        }
        return resultVo;
    }

    @PostMapping("get/teach")
    public Object getTeach(@RequestBody Teach teach){

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
        VoUtils.copyProperties(temp, teachVo,"teachId","name","type","teacherId","teacherName","behavior","test","exam","credit","teachTime", "page", "rows");
        List<Teach> list = teachService.findByPage(teachVo);
        PageInfo<Teach> pageInfo = new PageInfo<Teach>(list);
        resultVo.getInstance(HttpStatus.OK.toString(), pageInfo);
        return resultVo;
    }

}
