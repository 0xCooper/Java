package com.zlt.entity;

import java.util.List;


public class Teacher {
	private int tid;
	private String tname;
	private List<Student> students;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Teacher() {}
	
	public Teacher(int tid,String tname,List<Student> students) {
		this.tid=tid;
		this.tname=tname;
		this.students=students;
	}
	
	
	//对外数据展示
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname +", students=" + students + "]";
	}
}
