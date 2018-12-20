package com.univer.course.utils;

import com.univer.course.po.Course;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-20 09:02
 */
public class Main {

    public Course toJson (){
        Course course = new Course();
        course.setCourseId(null);
        course.setDescription("描述一下");
        course.setFacultyId(Long.valueOf(1));
        return course;
    }
    public static void main(String[] args){

    }
}
