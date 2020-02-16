package com.li.RedisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-16 20:36
 **/
public class PipeLine {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("RedisTemplate.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        SessionCallback callback=new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i=0;i<100000;i++){
                    int j=i+1;
                    redisOperations.boundValueOps("pipeline_key_"+j).set("pipeline_value_"+j);
                    redisOperations.boundValueOps("pipeline_key_"+j).get();
                }
                return null;
            }
        };
        Long start=System.currentTimeMillis();
        List<String> list = redisTemplate.executePipelined(callback);
        for (String s:list){
            System.out.println(s);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
