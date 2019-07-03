package com.univer.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-12 15:01
 */
@SpringBootApplication(scanBasePackages = {"com.univer"})
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = "com.univer.credit.mapper" )
public class ServiceCreditApplication {
    public static void main(String[] args){
        SpringApplication.run(ServiceCreditApplication.class,args);
    }
}
