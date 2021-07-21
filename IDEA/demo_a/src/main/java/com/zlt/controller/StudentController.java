package com.zlt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlt.dao.StudentDao;
import com.zlt.dao.TeacherDao;
import com.zlt.entity.Student;
import com.zlt.entity.Teacher;

@Controller
public class StudentController {
	
	//接口注入
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherDao teacherDao;
	
	@RequestMapping(value="showallstudent")
	@ResponseBody
	public String showAllStudent() {
		return studentDao.showAllStudent().toString();
	}
	
	@GetMapping(value="updatestudent")
	@ResponseBody
	public String updateStudent( String id,String name) {
		int myid = Integer.parseInt(id);
		Student s = new Student(myid, name);
		int i = studentDao.updateStudent(s);
		if(i>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	/*//4日不太标准的删除和添加方法，但这里的增添可以指定id，比如像被删除的sid=3位置添加一个新学生
	@RequestMapping(value="dlt")
	@ResponseBody
	public String dltStudent(int id) {
		studentDao.dltStudent(id);
		return studentDao.showAllStudent().toString();
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String addStudent(int id, String name) {
		studentDao.addStudent(id,name);
		return studentDao.showAllStudent().toString();
	}
	*/
	
	@RequestMapping(value="dltstudent")
	@ResponseBody
	public String dltStudent(HttpServletRequest request) {
		String id = request.getParameter("id");
		int i = studentDao.dltStudent(Integer.parseInt(id));
		if(i>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping(value="addstudent")
	@ResponseBody
	public boolean addStudent(String name) {
		return studentDao.addStudent(name);
	}
	
	//查老师名下学生
	@RequestMapping(value="studentbyid")
	@ResponseBody
	public List<Student> getStudentById(int id){
		return teacherDao.getTeacherById(id).getStudents();
	}
	
	//通过学生姓名查老师
	//这里的返回结果包含了老师的学生，而不是null
	@RequestMapping(value="teacherbysname")
	@ResponseBody
	public Teacher getTeacherBySname(String name) {
		//return studentDao.getTeacherBySid(id).getTeacher();
		return teacherDao.getTeacherById(studentDao.getTeacherBySname(name).getTeacher().getTid());
		//return studentDao.getTeacherBySname(name).getTeacher();
		//return studentDao.getTeacherBySid(id).getTeacher().getTid();
	}
}
