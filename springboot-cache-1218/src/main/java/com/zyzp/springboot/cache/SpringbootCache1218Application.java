package com.zyzp.springboot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootCache1218Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCache1218Application.class, args);
    }

}

