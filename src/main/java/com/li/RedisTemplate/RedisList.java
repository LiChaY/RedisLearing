package com.li.RedisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-13 21:27
 **/
public class RedisList {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ApplicationContext context=new ClassPathXmlApplicationContext("RedisTemplate.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        String first="linkedListFirst";
        String second="linkedListSecond";
        String third="linkedListThird";
       // redisTemplate.opsForList().leftPushAll(first, "1","2","3","4","5");
       redisTemplate.getConnectionFactory().getConnection().lInsert(first.getBytes("utf-8"), RedisListCommands.Position.AFTER, "2".getBytes("utf-8"),"6".getBytes("utf-8") );
        List range = redisTemplate.opsForList().range(first, 0, 5);
        Iterator iterator = range.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
