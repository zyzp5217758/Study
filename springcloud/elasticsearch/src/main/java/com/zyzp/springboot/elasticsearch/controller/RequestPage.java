package com.zyzp.springboot.elasticsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RequestPage {

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/userLogin")
    public String userLogin(){
        return "page/login";
    }

    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path")String path){
        return "level1/"+path;
    }

    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path")String path){
        return "level2/"+path;
    }
}
