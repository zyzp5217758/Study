package com.zyzp.dubbo.stucomsumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class StuComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuComsumerApplication.class, args);
    }

}

