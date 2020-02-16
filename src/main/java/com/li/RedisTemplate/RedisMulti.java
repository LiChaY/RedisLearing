package com.li.RedisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.Iterator;
import java.util.List;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-14 21:00
 **/
public class RedisMulti {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("RedisTemplate.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        SessionCallback sessionCallback=new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
               redisOperations.multi();
               redisOperations.boundValueOps("key1").set("value2");
               redisOperations.boundValueOps("key1").get();
                List exec = redisOperations.exec();
                Iterator iterator = exec.iterator();
                while (iterator.hasNext()){
                    System.out.println("exec.."+iterator.next());
                }
                Object key1 = redisTemplate.opsForValue().get("key1");
                return key1;
            }
        };
        String execute = (String) redisTemplate.execute(sessionCallback);
        System.out.println(execute);
    }


}
