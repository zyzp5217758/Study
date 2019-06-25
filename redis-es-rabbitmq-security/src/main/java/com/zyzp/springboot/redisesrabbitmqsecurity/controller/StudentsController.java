package com.zyzp.springboot.redisesrabbitmqsecurity.controller;

import com.zyzp.springboot.redisesrabbitmqsecurity.entity.Students;
import com.zyzp.springboot.redisesrabbitmqsecurity.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping(value = "/getStudentsBySid/{sid}")
    public Students getStudentsBySid(@PathVariable("sid") String sid){
        return studentsService.getStudentsById(sid);
    }
}
