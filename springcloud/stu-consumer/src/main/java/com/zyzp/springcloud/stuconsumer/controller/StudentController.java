package com.zyzp.springcloud.stuconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

    private static final String serviceId = "stu-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getStudent")
    public String getStudent(){
        return restTemplate.getForObject("http://"+serviceId+"/getStudents",String.class);
    }
}
