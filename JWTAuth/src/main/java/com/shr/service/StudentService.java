package com.shr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shr.entity.Student;
import com.shr.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JWTService jwtService;

	public Student signin(Student student) {
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		return studentRepo.save(student);
	}

	public List<Student> getallstd() {
		return studentRepo.findAll();
	}

	public String verify(Student student) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(student.getUsername(), student.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(student.getUsername());
		}
		return "fails!";

		
	}

}
