package com.zyzp.springboot.cache.util;

import com.zyzp.springboot.cache.entity.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class RabbitMq {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @RabbitListener(queues = "zyzp.news")
    public void buyBook(Book book) throws MessagingException {
        /*SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("今晚开会");
        mailMessage.setText("今晚7点开会，出版书"+book);
        mailMessage.setFrom("192583306@qq.com");
        mailMessage.setTo("943571986@qq.com");*/
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage,true);
        mimeMessageHelper.setSubject("今晚七点开会");
        mimeMessageHelper.setText("今晚7点开会，出版书"+book);
        mimeMessageHelper.setFrom("192583306@qq.com");
        mimeMessageHelper.setTo("943571986@qq.com");
        mimeMessageHelper.addAttachment("book.jpg",new File("C:\\Users\\Administrator\\Desktop\\11.jpg"));
        mimeMessageHelper.addAttachment("book1.jpg",new File("C:\\Users\\Administrator\\Desktop\\timg.jpg"));
        mailSender.send(mailMessage);
    }

    @Scheduled(cron = "0-5 * * * * *")
    public void sendMsg(){
        System.out.println("sendMsg success");
    }
}
