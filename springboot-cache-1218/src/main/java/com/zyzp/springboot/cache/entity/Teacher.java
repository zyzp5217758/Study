package com.zyzp.springboot.cache.entity;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String tid;
    private String tname;

    public Teacher() {
    }

    public Teacher(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
