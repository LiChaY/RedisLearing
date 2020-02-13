package com.li.RedisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        RedisTemplate redisTemplate= (RedisTemplate) context.getBean("redisTemplate");
        Role role=new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        redisTemplate.opsForValue().set("role_1", role);
        Role role_1 = (Role) redisTemplate.opsForValue().get("role_1");
        SessionCallback sessionCallback=()->{


        }
        System.out.println(role_1);


    }
}
