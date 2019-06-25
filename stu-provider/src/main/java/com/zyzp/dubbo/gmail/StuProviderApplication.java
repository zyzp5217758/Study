package com.zyzp.dubbo.gmail;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class StuProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuProviderApplication.class, args);
    }

}

