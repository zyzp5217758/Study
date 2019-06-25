package com.zyzp.springcloud.provider.service;

import com.entity.Students;
import com.zyzp.springcloud.provider.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentMapper studentMapper;

    public Students getStudentBySid(String sid){
        return studentMapper.getStudentBySid(sid);
    }

    public List<Students> getAllStudents(){
        return studentMapper.getAllStudents();
    }
}
