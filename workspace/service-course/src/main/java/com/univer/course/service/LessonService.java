package com.univer.course.service;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.univer.course.mapper.LessonMapper;
import com.univer.course.po.Lesson;
import com.univer.course.vo.LessonVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 16:09
 */
@Service
public class LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    public Integer addLesson(List<Lesson> list){
        Integer result = lessonMapper.insertList(list);
        return result;
    }

    public List<Lesson> findByPage(LessonVo lessonVo){
        if(lessonVo.getPage() != null && lessonVo.getRows()!=null){
            PageHelper.startPage(lessonVo.getPage(),lessonVo.getRows());
        }
        Map<String, Object> map = new HashMap<>(16);
        if(!StringUtils.isEmpty(lessonVo.getName())){
            map.put("name",lessonVo.getName());
        }
        if(!StringUtils.isEmpty(lessonVo.getType())){
            map.put("type",lessonVo.getType());
        }
        if(!StringUtils.isEmpty(lessonVo.getTeacherName())){
            map.put("teacherName",lessonVo.getTeacherName());
        }
        return lessonMapper.selectByCondition(map);
    }

    /**
     * 查询课程详情
     * @param id
     * @return
     */
    public LessonVo detail(Long id){
        Lesson lesson = lessonMapper.selectByPrimaryKey(id);
        LessonVo lessonVo = null;
        if(lesson!=null){
            lessonVo = new LessonVo();
            BeanUtils.copyProperties(lesson, lessonVo);
        }
        return lessonVo;
    }

    /**
     * 更新课程
     * @param lessonVo
     * @return
     */
    public Boolean updateLesson(LessonVo lessonVo){
        Lesson lesson = new Lesson();
        BeanUtils.copyProperties(lessonVo,lesson);
        int result = lessonMapper.updateByPrimaryKeySelective(lesson);
        if(result ==1 ){
            return true;
        }else {
            return false;
        }
    }


}
