package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.TeacherDao;
import com.ty.dto.Teacher;

@Component
public class TeacherService {

	@Autowired
	TeacherDao dao;
	
	public Teacher saveTeacher(Teacher teacher) {
	
		return dao.saveTeacher(teacher);
	}
	
	public List<Teacher> getAllTeacher(){
		
		return dao.getAllTeacher();
	}
	
	public void deleteTeacher(int id) {
	   dao.deleteById(id);
	}
	
	public Teacher updateTeacher(Teacher teacher) {
		
		return dao.updateTeacher(teacher);
	}
	
	public Teacher  getTeacherById(int id) {
		
		return dao.getTeacherById(id);
	}
}
