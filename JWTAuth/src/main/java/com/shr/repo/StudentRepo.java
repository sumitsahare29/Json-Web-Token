package com.shr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shr.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findByusername(String username);

}
