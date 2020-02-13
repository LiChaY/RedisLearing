package com.li.RedisTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-12 18:08
 **/
public class RedisTest {
    public static void main(String[] args) {

        JedisPoolConfig poolConfig=new JedisPoolConfig();
        //最大空闲数
        poolConfig.setMaxIdle(50);
        //最大连接数
        poolConfig.setMaxTotal(100);
        //最大等待毫秒数
        poolConfig.setMaxWaitMillis(20000);
        JedisPool jedisPool=new JedisPool(poolConfig, "localhost");
        Jedis resource = jedisPool.getResource();

        Jedis jedis = new Jedis("localhost", 6379);
        int i=0;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if (end - currentTimeMillis >= 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        }finally {
            jedis.close();
        }
        System.out.println("redis 每秒操作： "+i+"次");

    }


}
