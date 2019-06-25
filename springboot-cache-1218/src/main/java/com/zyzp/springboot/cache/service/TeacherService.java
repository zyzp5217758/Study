package com.zyzp.springboot.cache.service;


import com.zyzp.springboot.cache.entity.Teacher;
import com.zyzp.springboot.cache.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(keyGenerator = "myKeyGenerator")
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Cacheable(cacheNames = {"stu3","stu4"},condition = "#root.args[0]>0",unless="#result==null",keyGenerator = "myKeyGenerator"/*,cacheManager = "stuCacheManager"*/)
    public Teacher getTeachers(Integer sid){
        if(sid==1){
            return null;
        }
        return teacherMapper.getTeachers();
    }
}
