package com.li.RedisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-12 19:17
 **/
public class hash {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("RedisTemplate.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        String key="hash";
        Map<String,String> map=new HashMap<String, String>();
        map.put("tom", "33");
        map.put("jack", "11");
        //相当于 hmset batch设置
        redisTemplate.opsForHash().putAll(key,map);
        //相当于 hset
        redisTemplate.opsForHash().put(key, "smith", "44");
        printValue(redisTemplate, key, "jack");
        //相当于 hexists key filed
        Boolean smith = redisTemplate.opsForHash().hasKey(key, "smith");
        System.out.println(smith);
        //相当于 hgetall
        Map<String,String> entries = redisTemplate.opsForHash().entries(key);
        System.out.println("遍历 key hash...");
        for(Map.Entry<String,String> entry:entries.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }
        //hincrby
        Long incrementByLong = redisTemplate.opsForHash().increment(key, "smith", 3);
        System.out.println(incrementByLong);
    }
    public static void printValue(RedisTemplate redisTemplate,String key,String filed){
        Object o = redisTemplate.opsForHash().get(key,filed);
        System.out.println(o);
    }
}
