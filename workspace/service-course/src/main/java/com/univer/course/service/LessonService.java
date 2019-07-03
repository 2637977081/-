package com.univer.course.service;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.univer.course.enums.CourseTypeEnum;
import com.univer.course.mapper.CourseMapper;
import com.univer.course.mapper.LessonMapper;
import com.univer.course.po.Course;
import com.univer.course.po.Lesson;
import com.univer.course.po.Teach;
import com.univer.course.redis.RedisProducer;
import com.univer.course.vo.LessonVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.*;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 16:09
 */
@Service
public class LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private RedisProducer redisProducer;

    public Lesson addLesson(Lesson temp){
        Integer result = lessonMapper.insert(temp);
        Condition condition = new Condition(Lesson.class);
        Condition.Criteria criteria = condition.createCriteria();
        if(temp.getCode() !=null){
            criteria.andEqualTo("code",temp.getCode());
        }
        Lesson lesson  = lessonMapper.selectByCondition(condition).get(0);
        Condition courseCondition = new Condition(Course.class);
        Condition.Criteria courseCriteria = courseCondition.createCriteria();
        courseCriteria.andEqualTo("courseId",lesson.getCourseId());
        Course course = courseMapper.selectByCondition(courseCondition).get(0);
        //将选修课放入队列
        if(CourseTypeEnum.ELECTIVE.toString().equals(course.getType())){
            for(int i=0;i<course.getMaxnum();i++){
                String num = String.format("3%s",i);
                redisProducer.sendResourceMessage(lesson.getCode(),lesson.getLessonId()+num);
            }
        }
        return lesson;
    }
    public List<Lesson> addLessons(List<Lesson> temp,String type){
        Integer result = lessonMapper.insertList(temp);
        Long courseId = temp.get(0).getCourseId();
        Lesson lesson = new Lesson();
        lesson.setCourseId(courseId);
        List<Lesson> list = lessonMapper.select(lesson);
        //将选修课放入队列
        if(CourseTypeEnum.isExisted(type)){
            for(Lesson l:list){
                Condition courseCondition = new Condition(Course.class);
                Condition.Criteria courseCriteria = courseCondition.createCriteria();
                courseCriteria.andEqualTo("courseId",l.getCourseId());
                Course course = courseMapper.selectByCondition(courseCondition).get(0);
                for(int i=0;i<course.getMaxnum();i++){
                    String num = String.format("3%s",i);
                    redisProducer.sendResourceMessage(l.getCode(),l.getLessonId()+num);
                }
            }
        }
        return list;
    }

    public List<Lesson> findByPage(LessonVo lessonVo){
        if(lessonVo.getPage() != null && lessonVo.getRows()!=null){
            PageHelper.startPage(lessonVo.getPage(),lessonVo.getRows());
        }else {
            PageHelper.startPage(1,10);
        }
        Condition condition = new Condition(Lesson.class);
        Map<String, Object> map = new HashMap<>(16);
        if(lessonVo.getCourseId()!=null){
            condition.createCriteria().andEqualTo("courseId",lessonVo.getCourseId());
        }
        if(!StringUtils.isEmpty(lessonVo.getType())){
            condition.createCriteria().andEqualTo("type",lessonVo.getType());
        }
        if(lessonVo.getTeacherId()!=null){
            condition.createCriteria().andEqualTo("teacherId",lessonVo.getTeacherId());
        }
        if(!StringUtils.isEmpty(lessonVo.getName())){
            condition.createCriteria().andLike("name","%"+lessonVo.getName()+"%");
        }
        condition.createCriteria().andEqualTo("status","enabled");
        return lessonMapper.selectByCondition(condition);
    }

    public List<Map> findAllByPage(LessonVo lessonVo){
        if(lessonVo.getPage() != null && lessonVo.getRows()!=null){
            PageHelper.startPage(lessonVo.getPage(),lessonVo.getRows());
        }else {
            PageHelper.startPage(1,10);
        }
        Condition condition = new Condition(Lesson.class);
        if(lessonVo.getCourseId()!=null){
            condition.createCriteria().andEqualTo("courseId",lessonVo.getCourseId());
        }
        if(!StringUtils.isEmpty(lessonVo.getType())){
            condition.createCriteria().andEqualTo("type",lessonVo.getType());
        }
        if(lessonVo.getTeacherId()!=null){
            condition.createCriteria().andEqualTo("teacherId",lessonVo.getTeacherId());
        }
        if(!StringUtils.isEmpty(lessonVo.getName())){
            condition.createCriteria().andLike("name","%"+lessonVo.getName()+"%");
        }
        condition.createCriteria().andEqualTo("status","enabled");
        List<Lesson> lessonList = lessonMapper.selectByCondition(condition);
        List<Map> mapList = new ArrayList<>();
        for(Lesson l:lessonList){
            Map<String,Object> map = new HashMap<>(16);
            Course c = new Course();
            c.setCourseId(l.getCourseId());
            Course course = courseMapper.selectByPrimaryKey(c);
            if(course.getType().equals("elective")){
                map.put("course",course);
                map.put("lesson",l);
                mapList.add(map);
            }
        }
        return mapList;
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

    /**
     * 课程是否存在
     * @param lessonVo
     * @return
     */
    public Boolean isExistedLesson(LessonVo lessonVo){
        Boolean bool = false;
        Condition condition = new Condition(Lesson.class);
        Condition.Criteria criteria = condition.createCriteria();
        if(lessonVo.getName() !=null){
            criteria.andEqualTo("name",lessonVo.getName());
        }
        int size = lessonMapper.selectCountByCondition(condition);
        if(size>0){
            bool = true;
        }
        return bool;
    }
}
