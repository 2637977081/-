package com.univer.base.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univer.base.vo.ResultVo;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author hongjiao
 */
@Aspect
@Component
public class ExceptionAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 异常切面
     */
    @Pointcut("execution(* com.univer.base.exception.HandlerController.*(..))")
    public void exceptionLog(){}

    /**
     * 异常日志打印
     */
    @AfterReturning(returning = "ret", pointcut = "exceptionLog() && args(e)")
    public void doAfterReturning(ResultVo ret, Exception e) throws Throwable {
        logger.warn(objectMapper.writeValueAsString(ret));
        logger.error(objectMapper.writeValueAsString(e.getMessage()));
    }
}
