package com.univer.course.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-04 11:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RedisProducer {
    @Autowired
    private StringRedisTemplate template;

    public void sendResourceMessage(String key,String message){
        template.opsForList().leftPush(key,message);
    }
}
