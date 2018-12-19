package com.univer.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-13 15:56
 */
@SpringBootApplication
@MapperScan(basePackages = "com.univer.course.mapper" )
public class ServiceCourseApplication {
    public static void main(String[] args){
        SpringApplication.run(ServiceCourseApplication.class,args);
    }
}
