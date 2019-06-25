package com.zyzp.springboot.rabbit.service;

import com.zyzp.springboot.rabbit.entity.Students;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

@Service
public class StudentsService {

    /*@RabbitListener(queues = {"zyzp.news"})*/
    public void getStudents(Students students){
        System.out.println("监听到students信息为"+students);
    }

    @RabbitListener(queues = "zpzy.nwes")
    public void getMessage(Message message){
        System.out.println("消息头为"+message.getMessageProperties());
        System.out.println("消息体为"+message.getBody());
        byte[] body = "nihao".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(body);

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(inputStream));
            //Object o = objectInputStream.readObject();
            //System.out.println(o);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("出问题了");
        }
    }

}
