package com.zlt.com.controller;

import com.zlt.com.domain.User;
import com.zlt.com.dao.UserDao;

public class UserController {
    UserDao usrDao;
    public String loginValidate(String name ,String pass){
        User user =usrDao.findByNameAndPassword(name,pass);
        if(user==null){
            return  "登录失败";
        }else {
            return "登录成功";
        }
    }

}
