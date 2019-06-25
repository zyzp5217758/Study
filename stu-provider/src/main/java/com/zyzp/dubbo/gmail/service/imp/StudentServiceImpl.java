package com.zyzp.dubbo.gmail.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.validation.MethodValidated;
import com.zyzp.dubbo.gmail.entity.Students;
import com.zyzp.dubbo.gmail.service.StudentsService;
import org.springframework.stereotype.Component;


@Service(version = "1.0.0")
@Component
public class StudentServiceImpl implements StudentsService {

    @Override
    public Students getStudentsBySid(String sid){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Students("111","zhangsan",20,99.0);
    }
}
