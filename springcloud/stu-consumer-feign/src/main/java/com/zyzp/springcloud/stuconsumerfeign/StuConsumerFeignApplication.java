package com.zyzp.springcloud.stuconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages="com.zyzp.springcloud")
public class StuConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuConsumerFeignApplication.class, args);
    }

}

