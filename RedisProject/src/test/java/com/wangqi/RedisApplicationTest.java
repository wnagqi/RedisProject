package com.wangqi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class RedisApplicationTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void testString(){
        redisTemplate.opsForValue().set("name","王琦");
        Object result = redisTemplate.opsForValue().get("name");
        System.out.println("result = " + result);
    }
}
