package com.zyzp.springcloud.teaconsumerfeign.controller;

import com.zyzp.springcloud.teaconsumerfeign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/consumer/getDiscoveryClient")
    public DiscoveryClient getDiscoveryClient(){
        return teacherService.getDiscoveryClient();
    }
}
