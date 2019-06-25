package com.zyzp.springcloud.stuapi.service;

import com.zyzp.springcloud.stuapi.entity.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "stu-provider")
public interface StudentService {
    @GetMapping("/getStudents")
    public Student getStudents();
}
