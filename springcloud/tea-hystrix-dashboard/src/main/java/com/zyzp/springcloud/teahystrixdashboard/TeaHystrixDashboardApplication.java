package com.zyzp.springcloud.teahystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class TeaHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaHystrixDashboardApplication.class, args);
    }

}

