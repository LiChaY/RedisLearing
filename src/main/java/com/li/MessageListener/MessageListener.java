package com.li.MessageListener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-16 20:51
 **/
public class MessageListener implements org.springframework.data.redis.connection.MessageListener {
    private RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] messageBody = message.getBody();
        String deserialize = (String) redisTemplate.getValueSerializer().deserialize(messageBody);
        System.out.println(deserialize);
        byte[] channel = message.getChannel();
        String chanel = (String) redisTemplate.getValueSerializer().deserialize(channel);
        System.err.println(chanel);
        String byteString=new String(bytes);
        System.err.println(byteString);
    }
}
