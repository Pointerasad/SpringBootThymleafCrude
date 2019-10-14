package com.spring.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.model.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	 List<Student> findByName(String name);
}
