package com.wwt.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    public void testRedis() {
        RedisConnection connection = redisConnectionFactory.getConnection();
        connection.set("wang".getBytes(), "hello".getBytes());
        byte[] ba = connection.get("wang".getBytes());
        String str = new String(ba);
        System.out.println(str);
    }
}
