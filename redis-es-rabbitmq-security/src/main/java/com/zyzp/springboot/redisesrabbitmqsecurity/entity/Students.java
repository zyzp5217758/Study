package com.zyzp.springboot.redisesrabbitmqsecurity.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "study",type = "students")
public class Students implements Serializable {

    private String sid;
    private String sname;
    private Integer age;
    private Double score;

    public Students() {
    }

    public Students(String sid, String sname, Integer age, Double score) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.score = score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
