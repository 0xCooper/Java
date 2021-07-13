package com.zlt.com.controller;
import com.zlt.com.dao.HelloDao;
import  org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {
    @GetMapping("hello1")
    public  String test1(){
        return "hello springboot";
    }

    @GetMapping("hello2")
    public String test2(String str){
        return "hello"+str;
    }

    @GetMapping("login")
    public String login(String name,String pass){
        HelloDao dao = new HelloDao();
        boolean isLogin= dao.findByNameAndPass(name, pass);
        if(isLogin){
            return  "success";
        }else{
            return "false";
        }
//        return "hello"+name;
    }
}
