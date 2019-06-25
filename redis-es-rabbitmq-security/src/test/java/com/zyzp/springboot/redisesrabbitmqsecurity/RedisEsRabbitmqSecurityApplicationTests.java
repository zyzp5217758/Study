package com.zyzp.springboot.redisesrabbitmqsecurity;

import com.zyzp.springboot.redisesrabbitmqsecurity.entity.Students;
import com.zyzp.springboot.redisesrabbitmqsecurity.repository.StudentsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisEsRabbitmqSecurityApplicationTests {

    @Autowired
    private StudentsRepository studentsRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        Students s = new Students("111","lisi",20,98.0);
        studentsRepository.index(s);
    }
}

