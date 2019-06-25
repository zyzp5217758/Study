package com.zyzp.springcloud.teaprovider8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class TeaProvider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(TeaProvider8003Application.class, args);
    }

}

