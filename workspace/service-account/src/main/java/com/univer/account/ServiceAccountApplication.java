package com.univer.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tk.mybatis.spring.annotation.MapperScan;

import javax.validation.Validator;

/**
 * @author guwei test
 */
@SpringBootApplication(scanBasePackages = {"com.univer"})
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = "com.univer.account.mapper" )
public class ServiceAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAccountApplication.class, args);
	}
	
	@Bean(name = "validator")
    public Validator getValidator(MessageSource messageSource){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

}
