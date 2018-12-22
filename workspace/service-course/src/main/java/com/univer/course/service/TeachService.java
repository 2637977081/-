package com.univer.course.service;

import com.github.pagehelper.PageHelper;
import com.univer.base.util.VoUtils;
import com.univer.course.mapper.LessonMapper;
import com.univer.course.mapper.TeachMapper;
import com.univer.course.po.Lesson;
import com.univer.course.po.Teach;
import com.univer.course.redis.RedisConsumer;
import com.univer.course.vo.TeachVo;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-21 11:57
 */
@Service
public class TeachService {

    @Autowired
    private TeachMapper teachMapper;

    @Autowired
    private RedisConsumer redisConsumer;

    @Autowired
    private LessonMapper lessonMapper;

    public List<Teach> addTeach(List<Teach> temp){
        Integer result = teachMapper.insertList(temp);
        Teach teach = new Teach();
        teach.setLessonId(temp.get(0).getLessonId());
        List<Teach> list = teachMapper.select(teach);
        return list;
    }

    /**
     * 抢课
     */
    public Teach getTeach(TeachVo temp) throws Exception{
        Lesson lesson = lessonMapper.selectByPrimaryKey(temp.getLessonId());
        Teach teach = new Teach();
        VoUtils.copyProperties(temp, temp,"teachId","name","type","studentId","studentName");
        String value = redisConsumer.getResourceMessage(lesson.getCode());
        if(StringUtils.isEmpty(value)){
            return null;
        }else {
            teachMapper.insert(teach);
        }
        return teach;
    }

    public List<Teach> findByPage(TeachVo teachVo){
        if(teachVo.getPage() != null && teachVo.getRows()!=null){
            PageHelper.startPage(teachVo.getPage(),teachVo.getRows());
        }
        Map<String, Object> map = new HashMap<>(16);
        if(!StringUtils.isEmpty(teachVo.getName())){
            map.put("name",teachVo.getName());
        }
        if(!StringUtils.isEmpty(teachVo.getType())){
            map.put("type",teachVo.getType());
        }
        if(!StringUtils.isEmpty(teachVo.getStudentName())){
            map.put("studentName",teachVo.getStudentName());
        }
        return teachMapper.selectByCondition(map);
    }

    /**
     * 查询课程详情
     * @param id
     * @return
     */
    public TeachVo detail(Long id){
        Teach teach = teachMapper.selectByPrimaryKey(id);
        TeachVo teachVo = null;
        if(teach!=null){
            teachVo = new TeachVo();
            BeanUtils.copyProperties(teach, teachVo);
        }
        return teachVo;
    }

    /**
     * 更新课程
     * @param teachVo
     * @return
     */
    public Boolean updateTeach(TeachVo teachVo){
        Teach teach = new Teach();
        BeanUtils.copyProperties(teachVo,teach);
        int result = teachMapper.updateByPrimaryKeySelective(teach);
        if(result ==1 ){
            return true;
        }else {
            return false;
        }
    }


}
