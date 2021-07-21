package com.zlt.entity;

public class Student {
	private int sid;
	private String sname;
	private Teacher teacher;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	//无参构造器
	public Student() {}
	
	//有参构造器
	public Student(int sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	//对外数据展示
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname +"]";
	}
}
