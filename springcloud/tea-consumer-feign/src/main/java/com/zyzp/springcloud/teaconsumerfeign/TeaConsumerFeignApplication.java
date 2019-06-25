package com.zyzp.springcloud.teaconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.zyzp.springcloud.teaconsumerfeign.service")
public class TeaConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaConsumerFeignApplication.class, args);
    }

}

