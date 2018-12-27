package com.univer.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-11 19:00
 */
@SpringBootApplication(scanBasePackages = {"com.univer"})
@ServletComponentScan
@EnableTransactionManagement
public class ServiceStorageApplication {
    public static void main(String[] args){
        SpringApplication.run(ServiceStorageApplication.class,args);
    }
}
