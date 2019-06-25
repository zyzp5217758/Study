package com.zyzp.springcloud.provider.controller;

import com.entity.Students;
import com.zyzp.springcloud.provider.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/get/{sid}")
    public Students get(@PathVariable("sid") String sid){
        return studentsService.getStudentBySid(sid);
    }

    @GetMapping("/list")
    public List<Students> list(){
        return studentsService.getAllStudents();
    }
}
