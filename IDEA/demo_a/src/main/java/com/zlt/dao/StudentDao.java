package com.zlt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zlt.entity.Student;
import com.zlt.entity.Teacher;

@Mapper
public interface StudentDao {
	public List<Student> showAllStudent();
	public int updateStudent(Student student);
	/*
	public List<Student> dltStudent(int id);
	public List<Student> addStudent(@Param("sid") int id,@Param("sname") String name);
	*/
	public int dltStudent(@Param("sid") int id);
	public boolean addStudent(@Param("sname") String name);//sid会自增所以不需要提供
	public Student getTeacherBySname(@Param("sname") String name);
}
