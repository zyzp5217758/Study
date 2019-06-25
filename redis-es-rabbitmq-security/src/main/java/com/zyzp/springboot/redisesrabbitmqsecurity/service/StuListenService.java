package com.zyzp.springboot.redisesrabbitmqsecurity.service;

import com.zyzp.springboot.redisesrabbitmqsecurity.entity.Students;
import com.zyzp.springboot.redisesrabbitmqsecurity.repository.StudentsRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuListenService {

    @Autowired
    private StudentsRepository studentsRepository;

    @RabbitListener(queues = "zyzp.news")
    public void studentsListen(Students s){
        System.out.println("准备存储数据"+s);
        //studentsRepository.index(students);
        System.out.println("存储数据结束。。。");
    }
}
