package com.greatLearning.Student.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatLearning.Student.entity.Student;
import com.greatLearning.Student.service.StudentServices;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> student = studentServices.findAll();
		theModel.addAttribute("Students", student);
		return "students";
	}

	@RequestMapping("/insert")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("Students", student);
		return "insert";
	}

	@RequestMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Student student = studentServices.findById(id);
		model.addAttribute("Student", student);
		return "update";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student;
		if (id != 0) {
			student = studentServices.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		} else {
			student = new Student(firstName, lastName, course, country);
		}
		studentServices.save(student);
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentServices.deleteById(id);
		return "redirect:/students/list";

	}

	@RequestMapping(value = "/notFound")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("feedback", "Hello " + user.getName() + ", Access denied!");
		} else {
			model.addObject("feedback", "Only admin can access this page!");
		}
		model.setViewName("notfound");
		return model;
	}

}
