package com.example.jpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class CourseJDBCCommandlinerunner implements CommandLineRunner {
	
	//@Autowired
	//private CourseJDBCRepo repo;

	//@Autowired
	//private CourseJPARepository repo;
	
	@Autowired
	private CourseSpringDataJPARepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repo.save(new Course(1,"aws","zuk"));
		repo.save(new Course(2,"zire","uk"));
		repo.save(new Course(3,"zire","uk"));
		repo.deleteById(1l);
		
		System.out.println(repo.findById(2l));
		System.out.println(repo.findByAuthor("uk"));
		
	}

}
