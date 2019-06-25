package com.zyzp.dubbo.stucomsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.zyzp.dubbo.gmail.entity.Students;
import com.zyzp.dubbo.gmail.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentsController {

    @Reference(version = "1.0.0",timeout = 3000)
    private StudentsService studentsService;

    @GetMapping("/getStudentsBySid/{sid}")
    public Students getStudentsBySid(@PathVariable("sid") String sid){
        return studentsService.getStudentsBySid(sid);
    }
}
