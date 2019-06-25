package com.zyzp.springboot.cache.mapper;

import com.zyzp.springboot.cache.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public class StudentsMapper {


    public Students getStudents(){
        System.out.println("查询数据");
        return new Students("111","zhangsan",12,67.78);
    }
    public Integer delStudents(Integer sid){
        if(sid==3){
            throw new RuntimeException();
        }
        System.out.println("清除数据"+sid);
        return 1;
    }

    public Students updateStudents(Students students){
        return students;
    }
}
