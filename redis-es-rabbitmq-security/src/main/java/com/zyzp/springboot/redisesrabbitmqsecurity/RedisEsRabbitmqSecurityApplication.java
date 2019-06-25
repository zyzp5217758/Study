package com.zyzp.springboot.redisesrabbitmqsecurity;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@EnableRabbit
public class RedisEsRabbitmqSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisEsRabbitmqSecurityApplication.class, args);
    }

}

