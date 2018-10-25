package com.wwt.cache.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisCF() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPort(6379);
        //https://blog.csdn.net/xinshui151/article/details/79194980  bind redis机器的ip
        factory.setHostName("192.168.116.10");
//        factory.setPassword("hadoop");
//        factory.setUseSsl(true);
        return factory;

//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
//        redisStandaloneConfiguration.setHostName("192.168.116.10");
//        redisStandaloneConfiguration.setPort(6379);
//        redisStandaloneConfiguration.setDatabase(0);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of("hadoop"));
//
//        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
//        jedisClientConfiguration.connectTimeout(Duration.ofMillis(10));//  connection timeout
//
//        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
//                jedisClientConfiguration.build());
//
//
//        return factory;
    }
}
