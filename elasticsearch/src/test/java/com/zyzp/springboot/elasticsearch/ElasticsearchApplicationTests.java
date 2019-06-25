package com.zyzp.springboot.elasticsearch;

import com.zyzp.springboot.elasticsearch.entity.Students;
import com.zyzp.springboot.elasticsearch.repository.StudentsRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private StudentsRepository studentsRepository;
    @Test
    public void contextLoads() {
    }

    @Test
    public void addStudents() throws IOException {
        Students students = new Students("222","xiaozhang",10,99.0);
        Index index = new Index.Builder(students).index("zyzp").type("students").build();
        jestClient.execute(index);
    }

    @Test
    public void getStudents() throws IOException {

        String query = "{\n" +
                "\t\"query\":{\n" +
                "\t\t\"match_phrase\":{\n" +
                "\t\t\t\"sname\":\"lisi\"\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"highlight\":{\n" +
                "\t\t\"fields\":{\n" +
                "\t\t\t\"sname\":{}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        Search search = new Search.Builder(query).addIndex("zyzp").addType("students").build();
        SearchResult result = jestClient.execute(search);
        System.out.println(result.toString());
    }

    @Test
    public void addstudents(){
        Students students = new Students("888","xiaozhang",10,99.0);
        studentsRepository.index(students);
    }

    @Test
    public void test02() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("今天七点开会");
        mailMessage.setText("今晚七点开会");
        mailMessage.setTo("943571986@qq.com");
        mailMessage.setFrom("192583306@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    public void test03() throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);
        helper.setSubject("今晚七点开会");
        helper.setText("今晚七点开会");
        helper.setTo("943571986@qq.com");
        helper.setFrom("192583306@qq.com");
        helper.addAttachment("1.txt",new File("C:\\Users\\Administrator\\Desktop\\EditPlus\\1.txt"));
        mailSender.send(mimeMailMessage);
    }
}

