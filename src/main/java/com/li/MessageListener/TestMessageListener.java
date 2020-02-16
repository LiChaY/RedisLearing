package com.li.MessageListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-16 21:07
 **/
public class TestMessageListener {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("RedisTemplate.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        String channel="chat";
        redisTemplate.convertAndSend(channel, "I am lazy");
    }
}
