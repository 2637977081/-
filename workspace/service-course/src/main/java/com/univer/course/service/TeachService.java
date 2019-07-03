package com.univer.course.service;

import com.github.pagehelper.PageHelper;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.VoUtils;
import com.univer.course.mapper.CourseMapper;
import com.univer.course.mapper.LessonMapper;
import com.univer.course.mapper.TeachMapper;
import com.univer.course.po.Course;
import com.univer.course.po.Lesson;
import com.univer.course.po.Teach;
import com.univer.course.redis.RedisConsumer;
import com.univer.course.vo.TeachVo;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
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

    @Autowired
    private CourseMapper courseMapper;

    public List<Teach> addTeach(List<Teach> temp){
        if(temp.size()<1){
            return new ArrayList<>();
        }
        Integer result = teachMapper.insertList(temp);
        Teach teach = new Teach();
        teach.setLessonId(temp.get(0).getLessonId());
        List<Teach> list = teachMapper.select(teach);
        Lesson lesson = lessonMapper.selectByIds(temp.get(0).getLessonId()).get(0);
        lesson.setLessonId(Long.parseLong(temp.get(0).getLessonId()));
        lesson.setNum(list.size());
        lessonMapper.updateByPrimaryKey(lesson);
        return list;
    }

    /**
     * 抢课
     */
    public Teach getTeach(Teach temp) {
        Lesson lesson = lessonMapper.selectByPrimaryKey(temp.getLessonId());
        String value = redisConsumer.getResourceMessage(lesson.getCode());
        if(StringUtils.isEmpty(value)){
            return null;
        }else {
            teachMapper.insert(temp);
        }
        return temp;
    }

    public List<Teach> findByPage(TeachVo teachVo){
        if(teachVo.getPage() != null && teachVo.getRows()!=null){
            PageHelper.startPage(teachVo.getPage(),teachVo.getRows());
        }
        Condition condition = new Condition(Teach.class);
        if(!com.aliyuncs.utils.StringUtils.isEmpty(teachVo.getName())){
            condition.createCriteria().andLike("name","%"+teachVo.getName()+"%");
        }
        if(!com.aliyuncs.utils.StringUtils.isEmpty(teachVo.getType())){
            condition.createCriteria().andEqualTo("type",teachVo.getType());
        }
        if(teachVo.getLessonId()!=null){
            condition.createCriteria().andEqualTo("lessonId",teachVo.getLessonId());
        }
        if(teachVo.getStudentId()!=null){
            condition.createCriteria().andEqualTo("studentId",teachVo.getStudentId());
        }
        condition.createCriteria().andEqualTo("status","enabled");
        return teachMapper.selectByCondition(condition);
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
        Teach t = teachMapper.selectByPrimaryKey(teach);
        Lesson lesson = new Lesson();
        lesson.setLessonId(Long.valueOf(t.getLessonId()));
        Lesson l = lessonMapper.selectByPrimaryKey(lesson);
        Course course = new Course();
        course.setCourseId(l.getCourseId());
        Course c  =  courseMapper.selectByPrimaryKey(course);
        int behavior = teachVo.getBehavior()*c.getBehavior()/100;
        int test = teachVo.getTest()*c.getTest()/100;
        int exam = teachVo.getExam()*c.getExam()/100;
        int score = test + behavior+exam;
        int credit = 0;
        if(score>=90){
            credit = c.getCredit();
        }else if(score >=80){
            credit = (new Double(c.getCredit() * 0.8)).intValue();
        }else if(score >=60){
            credit = (new Double(c.getCredit() * 0.6)).intValue();
        }
        teach.setScore(score);
        teach.setCredit(credit);
        int result = teachMapper.updateByPrimaryKeySelective(teach);
        if(result ==1 ){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断这个学生是否已经在这个班级
     * @param studentId
     * @param lessonId
     * @return
     */
    public Boolean isExisted(Long studentId,String lessonId){
        Condition condition = new Condition(Teach.class);
        condition.createCriteria().andEqualTo("studentId",studentId);
        condition.createCriteria().andEqualTo("lessonId",lessonId);
        condition.createCriteria().andEqualTo("status",StatusEnum.ENABLED);
        int result = teachMapper.selectByCondition(condition).size();
        if(result >0 ){
            return true;
        }else {
            return false;
        }
    }
}
