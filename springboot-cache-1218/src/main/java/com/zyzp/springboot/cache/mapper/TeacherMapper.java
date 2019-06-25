package com.zyzp.springboot.cache.mapper;

import com.zyzp.springboot.cache.entity.Students;
import com.zyzp.springboot.cache.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher getTeachers(){
        System.out.println("查询数据");
        return new Teacher("t01","lisi");
    }

}
