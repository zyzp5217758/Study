package com.zyzp.springboot.elasticsearch.controller;

import com.zyzp.springboot.elasticsearch.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    private ScheduledService scheduledService;

    @GetMapping("/async")
    public String testAsync(){
        scheduledService.scheduledTask();
        return "success：asyncTask";
    }
}
