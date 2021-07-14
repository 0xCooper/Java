package com.zlt.boot.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//注释，解决跨域问题

public class RequestController {
    @GetMapping(value = "/getrequestinfo")
    public  String getrequest(){
        return "hello";
    }
    @PostMapping(value = "/getrequestinfo")
    public  String postrequest(){
        return "hello";
    }

}
