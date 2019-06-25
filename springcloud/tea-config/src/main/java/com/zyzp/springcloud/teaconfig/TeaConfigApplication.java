package com.zyzp.springcloud.teaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TeaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaConfigApplication.class, args);
    }

}

