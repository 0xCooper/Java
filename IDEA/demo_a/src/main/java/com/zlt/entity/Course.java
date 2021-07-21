package com.zlt.entity;

import java.util.Objects;

public class Course {
	private String course_id;
	private int type;//课程类型：1：直播；2：录播；3：课程
	private String course_name;
	private String course_teacher_name;
	private String course_categoryname;
	private String course_pic;
	private String course_introduce;

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCourse_pic() {
		return course_pic;
	}
	public void setCourse_pic(String course_pic) {
		this.course_pic = course_pic;
	}
	public String getCourse_introduce() {
		return course_introduce;
	}
	public void setCourse_introduce(String course_introduce) {
		this.course_introduce = course_introduce;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_teacher_name() {
		return course_teacher_name;
	}
	public void setCourse_teacher_name(String course_teacher_name) {
		this.course_teacher_name = course_teacher_name;
	}
	public String getCourse_categoryname() {
		return course_categoryname;
	}
	public void setCourse_categoryname(String course_categoryname) {
		this.course_categoryname = course_categoryname;
	}
	
	public Course(){}

	public Course(String course_id,int type,String course_name, String course_teacher_name, String course_categoryname, String course_pic, String course_introduce) {
		this.type=type;
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_teacher_name = course_teacher_name;
		this.course_categoryname = course_categoryname;
		this.course_pic = course_pic;
		this.course_introduce = course_introduce;
	}

	@Override
	public String toString() {
		return "Course{" +
				"course_id='" + course_id + '\'' +
				", type=" + type +
				", course_name='" + course_name + '\'' +
				", course_teacher_name='" + course_teacher_name + '\'' +
				", course_categoryname='" + course_categoryname + '\'' +
				", course_pic='" + course_pic + '\'' +
				'}';
	}
}
