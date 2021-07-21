package com.zlt.entity;

import java.util.List;

public class User {
	private String user_name;
	private String user_id;
	private String loginname;
	private String loginpassword;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getLoginname() {
		return loginname;
	}


	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getLoginpassword() {
		return loginpassword;
	}


	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}


	public User() {
	}

	public User(String user_name, String user_id, String loginname, String loginpassword) {
		this.user_name = user_name;
		this.user_id = user_id;
		this.loginname = loginname;
		this.loginpassword = loginpassword;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_ame='" + user_name + '\'' +
				", user_id='" + user_id + '\'' +
				", loginname='" + loginname + '\'' +
				", loginpassword='" + loginpassword + '\'' +
				'}';
	}
}
