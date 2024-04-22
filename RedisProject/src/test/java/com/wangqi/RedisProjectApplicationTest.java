package com.wangqi;


import com.alibaba.fastjson2.JSON;
import com.wangqi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class RedisProjectApplicationTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void testString(){

        redisTemplate.opsForValue().set("name","王琦");
        Object result = redisTemplate.opsForValue().get("name");
        System.out.println("result = " + result);

    }

    @Test
    void testUserJson(){
        User user = new User("王琦", 27);
        // 序列化
        String userJson = JSON.toJSONString(user);
        redisTemplate.opsForValue().set("user:wq",userJson);
        String userJsonString = redisTemplate.opsForValue().get("user:wq");
        // 反序列化
        User userObject = JSON.parseObject(userJsonString, User.class);
        System.out.println("userObject = " + userObject);

    }

    @Test
    void testHash(){
        redisTemplate.opsForHash().put("user:100","name","王琦");
        redisTemplate.opsForHash().put("user:100","age","27");
        Map<Object, Object> entries = redisTemplate.opsForHash().entries("user:100");
        System.out.println("entries = " + entries);
    }
}
