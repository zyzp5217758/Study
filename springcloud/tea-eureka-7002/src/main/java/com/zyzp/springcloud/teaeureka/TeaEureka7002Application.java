package com.zyzp.springcloud.teaeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TeaEureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(TeaEureka7002Application.class, args);
    }

}

