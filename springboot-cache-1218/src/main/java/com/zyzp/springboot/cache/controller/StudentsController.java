package com.zyzp.springboot.cache.controller;

import com.zyzp.springboot.cache.entity.Students;
import com.zyzp.springboot.cache.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;
    @GetMapping("/getStudents/{sid}")
    public Students getStudents(@PathVariable("sid") Integer sid){
        return studentsService.getStudents(sid);
    }

    @GetMapping("/delStudents/{sid}")
    public Integer delStudents(@PathVariable("sid") Integer sid){
        return studentsService.delStudents(sid);
    }

    @GetMapping("/updateStudents")
    public Students updateStudents(){
        Students students = new Students("222","zhangsan",12,67.78);
        return studentsService.updateStudents(students);
    }
    @GetMapping("/allMethod")
    public Students allMethod(){
        Students students = new Students("222","zhangsan",12,67.78);
        return studentsService.allMethod(students);
    }
}
