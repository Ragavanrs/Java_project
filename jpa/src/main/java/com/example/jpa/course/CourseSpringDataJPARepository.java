package com.example.jpa.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJPARepository  extends JpaRepository<Course, Long>{

	
	List<Course> findByAuthor(String author);
	
}
