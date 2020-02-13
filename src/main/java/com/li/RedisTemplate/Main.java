package com.li.RedisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-12 19:17
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("RedisTemplate.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("number", "5");

        Long increment = redisTemplate.opsForValue().increment("number", 5);

        System.out.println("number:"+increment);

        Long number = redisTemplate.getConnectionFactory().getConnection().decr(redisTemplate.getKeySerializer().serialize("number"));
        System.out.println("redisTemplate.getConnectionFactory.getConnection.decr(redisTemplate.getKeySerializer().serialize("+"nubmer))"+"\n"+number);

        Long decrBy = redisTemplate.getConnectionFactory().getConnection().decrBy(redisTemplate.getKeySerializer().serialize("number"), 3);
        System.out.println(decrBy);

        Double increment1 = redisTemplate.opsForValue().increment("number", 3.3);

        System.out.println(increment1);
    }
}
