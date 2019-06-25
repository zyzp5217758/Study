package com.zyzp.springcloud.stuconsumerfeign.factory;

import com.zyzp.springcloud.stuapi.entity.Student;
import com.zyzp.springcloud.stuconsumerfeign.service.StudentServiceFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory implements FallbackFactory<StudentServiceFeign> {
    @Override
    public StudentServiceFeign create(Throwable throwable) {
        return new StudentServiceFeign() {
            @Override
            public Student getStudents(String sid) {
                Student student = new Student();
                student.setSid("555");
                student.setSname("没有找到我");
                student.setAge(0);
                student.setScore(99.0);
                return student;
            }
        };
    }
}
