package com.example.jpa.course;


import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public void insert(Course course) {
		entitymanager.merge(course);
	}
	
	public Course selectid(long id) {
		
		return entitymanager.find(Course.class, id);
	}
public void delete(long id) {
		
	Course course=entitymanager.find(Course.class, id);
	
		entitymanager.remove(course); ;
	}
}
