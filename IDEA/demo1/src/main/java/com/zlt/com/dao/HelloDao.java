package com.zlt.com.dao;

public class HelloDao {
    public  boolean findByNameAndPass(String name ,String pass){
        if (name.equals("admin")&&pass.equals("admin")){
            return true;
        }else {
            return false;

        }
    }
}
