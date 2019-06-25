package com.zyzp.springcloud.teaprovider8002.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class TeaController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getDiscoveryClient/{tid}")
    @HystrixCommand(fallbackMethod = "hello")
    public DiscoveryClient getDiscoveryClient(@PathVariable("tid") String tid){
        System.out.println("provider8002");
        if(tid.equals("111")){
            throw new RuntimeException();
        }
        return discoveryClient;
    }

    public DiscoveryClient hello(@PathVariable("tid") String tid){
        return null;
    }
}
