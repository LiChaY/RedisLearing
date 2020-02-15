package com.li.RedisTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.Set;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-14 19:56
 **/
public class RedisSet {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("RedisTemplate.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        String unio="setUnio";
        String first="first";
        String second ="setSecond";
        String diff="diff";
        String inter="inter";
        //redisTemplate.opsForSet().add(second, "1","2","fuck","3","4", "5");
       // redisTemplate.opsForSet().add(first, "1","2","fuck");
        //redisTemplate.opsForSet().remove(second, "fuck");
       // redisTemplate.opsForSet().differenceAndStore(diff, first, second);

       // redisTemplate.opsForSet().differenceAndStore(first, second, diff);
        //redisTemplate.opsForSet().intersectAndStore(first, second, inter);
        redisTemplate.opsForSet().unionAndStore(first, second, unio);
        Set<String> secondMembers = redisTemplate.opsForSet().members(second);
        for (String member:secondMembers){
            System.out.println(member);
        }
        System.out.println("firstMembers...");
        Set<String> firstMembers = redisTemplate.opsForSet().members(first);
        for (String member:firstMembers){
            System.out.println(member);
        }
        System.out.println("diff.....");
        Set<String> diffMembers = redisTemplate.opsForSet().members(unio);
        for (String member:diffMembers){
            System.out.println(member);
        }

    }


}
