package com.zlt.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.zlt.entity.Teacher;

@Mapper
public interface TeacherDao {
	public List<Teacher> showAllTeacher();
	public Teacher getTeacherById(int tid);
	public String showTeacherandStudents(Integer id);
}
