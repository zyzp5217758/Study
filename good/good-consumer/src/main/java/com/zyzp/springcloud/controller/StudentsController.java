package com.zyzp.springcloud.controller;

import com.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentsController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/get/{sid}")
    public Students get(@PathVariable("sid")String sid){
        return restTemplate.getForObject("http://localhost:8085/get/"+sid,Students.class);
    }
}
