package com.zyzp.springcloud.stuprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyzp.springcloud.stuapi.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {

    @GetMapping(value = "/getStudents/{sid}")
    @HystrixCommand(fallbackMethod = "hello")
    public Student getStudents(@PathVariable("sid") String sid){
        if(sid.equals("111")) {
            throw new RuntimeException();
        }
        return new Student("111","zhangsan",20,99.0);
    }

    public Student hello(@PathVariable("sid") String sid){
        Student student = new Student();
        student.setSname("没有该同学");
        student.setSid(sid);
        return student;
    }
}
