package com.zyzp.springcloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.zyzp.springcloud.provider.mapper")
public class GoodProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodProviderApplication.class, args);
    }

}

