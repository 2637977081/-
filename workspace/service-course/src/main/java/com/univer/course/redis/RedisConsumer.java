package com.univer.course.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-04 12:01
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RedisConsumer {

    private Logger logger = LoggerFactory.getLogger(RedisConsumer.class);

    @Autowired
    private StringRedisTemplate template;

    public String getResourceMessage(String key){
        String message = template.opsForList().leftPop(key);
        logger.info("redis消费："+message);
        return message;
    }
}
