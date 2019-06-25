package com.zyzp.springboot.rabbit;

import com.rabbitmq.client.AMQP;
import com.zyzp.springboot.rabbit.entity.Students;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendMsg(){
        Students students = new Students("111","zhangsan",10,99.0);
        rabbitTemplate.convertAndSend("zyzp.news",students);
    }

    @Test
    public void addAmqp(){
        amqpAdmin.declareExchange(new DirectExchange("zyzp.direct"));
        amqpAdmin.declareQueue(new Queue("zyzp.queue"));
        amqpAdmin.declareBinding(new Binding("zyzp.queue",Binding.DestinationType.QUEUE,"zyzp.direct","zyzp.direct",null));
    }

    @Test
    public void sendMessage(){
        Students students = new Students("222","zhangsan",10,99.0);
        byte[] body = students.toString().getBytes();
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setAppId("studentsID");
        Message message = new Message(body,messageProperties);
        System.out.println(body.length);
        rabbitTemplate.convertAndSend("zyzp.topic","zyzp.news",message);
    }
}

