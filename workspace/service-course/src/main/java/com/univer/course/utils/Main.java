package com.univer.course.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.course.enums.CourseTypeEnum;
import com.univer.course.po.Course;
import com.univer.course.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 09:02
 */
public class Main {


    public String toJson () throws Exception{
        CourseVo course = new CourseVo();

        course.setName("高等数学1");
        course.setDescription("描述一下");
        course.setUniversityId(Long.valueOf(1));
        course.setUniversityName("北华大学");
//        course.setFacultyId(Long.valueOf(11));
//        course.setFacultyName("计算机科学技术学院");
//        course.setSubjectId(Long.valueOf(1101));
//        course.setSubjectName("计算机科学与技术");
        course.setType(CourseTypeEnum.ELECTIVE.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(course);
    }
    public static void main(String[] args) throws Exception{
        Main main = new Main();
        System.out.println(main.toJson());
    }
}
