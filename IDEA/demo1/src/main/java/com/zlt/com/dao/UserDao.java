package com.zlt.com.dao;

import com.zlt.com.domain.User;

import java.util.List;

/*
增删改查
*/
public interface UserDao {
    //java发送insert代码，发送到数据库执行
    //JDBC
    //输入输出
    public int  insert(User user);
    public int update(User user);
    public int  delete(int id);
    public List<User> findAll();
    public User findById(int id);
    public User findByNameAndPassword(String name,String password);

}
