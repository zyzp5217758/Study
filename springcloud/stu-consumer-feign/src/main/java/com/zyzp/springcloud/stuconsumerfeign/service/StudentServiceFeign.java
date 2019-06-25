package com.zyzp.springcloud.stuconsumerfeign.service;

import com.zyzp.springcloud.stuapi.entity.Student;
import com.zyzp.springcloud.stuconsumerfeign.factory.StudentFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "stu-provider",fallbackFactory = StudentFactory.class)
public interface StudentServiceFeign {
    @GetMapping("/getStudents/{sid}")
    public Student getStudents(@PathVariable("sid") String sid);
}
