package com.zyzp.springboot.redisesrabbitmqsecurity.service;

import com.zyzp.springboot.redisesrabbitmqsecurity.entity.Students;
import com.zyzp.springboot.redisesrabbitmqsecurity.mapper.StudentsMapper;
import com.zyzp.springboot.redisesrabbitmqsecurity.repository.StudentsRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Cacheable(value = "stu",key = "#sid",cacheManager = "stuCacheManager")
    public Students getStudentsById(String sid){
        Students s =  studentsMapper.getStudentBySid(sid);
        rabbitTemplate.convertAndSend("zyzp.news",s);

        return s;
    }



}
