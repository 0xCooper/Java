package com.zlt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlt.dao.TeacherDao;
import com.zlt.entity.Student;
import com.zlt.entity.Teacher;
@CrossOrigin
@Controller
public class TeacherController {
	@Autowired
	private TeacherDao teacherDao;
	
	public Teacher initTeacherStudent(Teacher t){
		if(teacherDao.getTeacherById(t.getTid()) != null) {
			return teacherDao.getTeacherById(t.getTid());
		}
		else {
			return t;
		}
	}
	
	@RequestMapping(value="showallteacher")
	@ResponseBody
	//public String showAllTeacher() {
	//	return teacherDao.showAllTeacher().toString();
	//}
	public String showAllTeacher(){
		List<Teacher> t = new ArrayList<Teacher>();
		List<Teacher> r = new ArrayList<Teacher>();
		t = teacherDao.showAllTeacher();
		for(int i=0;i<t.size();i++) {
			r.add(initTeacherStudent(t.get(i)));
		}
//		return t.toString();
		return r.toString();
	}
	
	@RequestMapping(value="showtas")
	@ResponseBody
	public String showTeacherandStudents(Integer id) {
		List<Teacher> t = new ArrayList<Teacher>();
		Teacher teacher = teacherDao.getTeacherById(id);
		return teacher.toString();
	}
}
