package com.shr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shr.entity.Student;
import com.shr.entity.StudentPrinciple;
import com.shr.repo.StudentRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Student student = studentRepo.findByusername(username);
		if (student == null) {
			System.out.println("Student Not Found!");
			throw new UsernameNotFoundException("Student Not Found!");
		}

		return new StudentPrinciple(student);
	}

}
