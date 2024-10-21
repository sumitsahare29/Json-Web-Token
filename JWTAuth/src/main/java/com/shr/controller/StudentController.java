package com.shr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shr.entity.Student;
import com.shr.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/register")
	public Student sign_in(@RequestBody Student student) {
		return studentService.signin(student);
	}

	@PostMapping("/login")
	public String login(@RequestBody Student student) {
		return studentService.verify(student);
	}

	@GetMapping("/getall")
	public List<Student> getall() {
		return studentService.getallstd();
	}

	@GetMapping("/csrftoken")
	public CsrfToken geCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}

	@GetMapping("/getsms")
	public String getsms() {
		return "welcome to my world!";
	}

}
