package com.zlt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zlt.entity.User;

@Mapper
public interface LoginDao {
	public User userLogin(@Param("name") String name,@Param("pwd") String pwd);
	public User regCheck(@Param("name") String name);

	public boolean addUser(@Param("user_id") String user_id,
						   @Param("loginname") String loginname,
						   @Param("school") String school,
						   @Param("mobilephone") String mobilephone,
						   @Param("email") String email,
						   @Param("loginpassword") String loginpassword,
						   @Param("name") String name
	);
}
