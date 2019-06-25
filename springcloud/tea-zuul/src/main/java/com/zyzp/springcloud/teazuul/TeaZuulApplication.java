package com.zyzp.springcloud.teazuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TeaZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaZuulApplication.class, args);
    }

}

