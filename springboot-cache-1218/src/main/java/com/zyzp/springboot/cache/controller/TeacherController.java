package com.zyzp.springboot.cache.controller;

import com.zyzp.springboot.cache.entity.Students;
import com.zyzp.springboot.cache.entity.Teacher;
import com.zyzp.springboot.cache.service.StudentsService;
import com.zyzp.springboot.cache.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @GetMapping("/getTeacher/{sid}")
    public Teacher getStudents(@PathVariable("sid") Integer sid){
        return teacherService.getTeachers(sid);
    }

}
