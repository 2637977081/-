package com.univer.course.service;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.univer.course.mapper.CourseMapper;
import com.univer.course.vo.CourseVo;
import com.univer.course.po.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-19 20:02
 */
@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 课程是否存在
     * @param courseVo
     * @return
     */
    public Boolean isExistedCourse(CourseVo courseVo){
        Boolean bool = false;
        Condition condition = new Condition(Course.class);
        Condition.Criteria criteria = condition.createCriteria();
        if(courseVo.getName() !=null){
            criteria.andEqualTo("name",courseVo.getName());
        }
        int size = courseMapper.selectCountByCondition(condition);
        if(size>0){
            bool = true;
        }
        return bool;
    }

    /**
     * 创建课程
     * @param courseVo
     * @return
     */
    public CourseVo saveCourse(CourseVo courseVo){
        Course course = new Course();
        BeanUtils.copyProperties(courseVo,course);
        int result = courseMapper.insertSelective(course);
        if(result == 1){
            return courseVo;
        }else {
            return null;
        }
    }

    /**
     * 更新课程
     * @param courseVo
     * @return
     */
    public Boolean updateCourse(CourseVo courseVo){
        Course course = new Course();
        BeanUtils.copyProperties(courseVo,course);
        int result = courseMapper.updateByPrimaryKeySelective(course);
        if(result ==1 ){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查询课程详情
     * @param id
     * @return
     */
    public CourseVo detail(Long id){
        Course course = courseMapper.selectByPrimaryKey(id);
        CourseVo courseVo = null;
        if(course!=null){
            courseVo = new CourseVo();
            BeanUtils.copyProperties(course, courseVo);
        }
        return courseVo;
    }

    public List<Course> findByPage(CourseVo courseVo){
        if(courseVo.getPage() != null && courseVo.getRows()!=null){
            PageHelper.startPage(courseVo.getPage(),courseVo.getRows());
        }
        Map<String, Object> map = new HashMap<>(16);
        if(!StringUtils.isEmpty(courseVo.getName())){
            map.put("name",courseVo.getName());
        }
        if(!StringUtils.isEmpty(courseVo.getType())){
            map.put("type",courseVo.getType());
        }
        if(courseVo.getUniversityId()!=null){
            map.put("universityId",courseVo.getUniversityId());
        }
        if(courseVo.getFacultyId()!=null){
            map.put("facultyId",courseVo.getFacultyId());
        }
        if(courseVo.getSubjectId()!=null){
            map.put("subjectId",courseVo.getSubjectId());
        }
        if(courseVo.getCreateId()!=null){
            map.put("createId",courseVo.getCreateId());
        }
        return courseMapper.selectByCondition(map);
    }
}
