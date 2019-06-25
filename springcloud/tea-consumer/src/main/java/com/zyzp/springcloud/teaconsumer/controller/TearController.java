package com.zyzp.springcloud.teaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TearController {

    private final static String TEACHER_PATH = "tea-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getDiscoveryClient")
    public DiscoveryClient getDiscoveryClient(){
        return restTemplate.getForObject("http://"+TEACHER_PATH+"/getDiscoveryClient",DiscoveryClient.class);
    }
}
