package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dto.Teacher;
import com.ty.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	TeacherService service;
	
	@RequestMapping("/loadteacher")
	public ModelAndView loadTeacher() {
		
		ModelAndView andView = new ModelAndView("teacher.jsp");
		andView.addObject("teacher",new Teacher());
		return andView;
	}
	
	@RequestMapping("/saveteacher")
	public ModelAndView saveTeacher(Teacher teacher) {
		
		Teacher teacher2 = service.saveTeacher(teacher);
		
		ModelAndView andView = new ModelAndView("");
		
		return andView;
	}
	
	@RequestMapping("/getallteacher")
	public ModelAndView getAllTeacher() {
	    List<Teacher> list = service.getAllTeacher();
		ModelAndView andView = new ModelAndView("display-teacher.jsp");
		andView.addObject("teacherlist",list);
		return andView;
	}
	
	@RequestMapping("/deleteteacher")
	public ModelAndView deleteTeacher(@RequestParam int id) {
		
		ModelAndView andView = new ModelAndView("/getallteacher");
	
		service.deleteTeacher(id);
		
		return andView;
	}
	

	
	@RequestMapping("/editTeacher")
	public ModelAndView editTeacher(@RequestParam int id) {
		
		ModelAndView andView = new ModelAndView("editteacher.jsp");
		andView.addObject("editteacher",service.getTeacherById(id));
		return andView;
	}
	
	@RequestMapping("/updateTeacher")
	public ModelAndView updateTeacher(@ModelAttribute Teacher teacher) { 
		
		ModelAndView andView = new ModelAndView("/getallteacher");
		
		service.updateTeacher(teacher);
		
		return andView;
	}
}
