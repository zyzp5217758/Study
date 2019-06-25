package com.zyzp.springcloud.stuconsumerfeign.controller;

import com.zyzp.springcloud.stuapi.entity.Student;
import com.zyzp.springcloud.stuapi.service.StudentService;
import com.zyzp.springcloud.stuconsumerfeign.service.StudentServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceFeign studentService;

    @GetMapping("/getStudents/{sid}")
    public Student getStudents(@PathVariable("sid")String sid){
        return studentService.getStudents(sid);
    }
}
