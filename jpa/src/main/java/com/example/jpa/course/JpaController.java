package com.example.jpa.course;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {

	@Autowired
	private CourseSpringDataJPARepository repo;
	
	@GetMapping("/get")
	public List<Course> GetCourse() {
		return repo.findAll();
		
	}
	@PostMapping(path = "/post")
	public void InsertCourse(@RequestBody Course course) {
		System.out.println(course);
		repo.save(course);
		System.out.println("Inserted the value successfully");
	}
	
	@GetMapping(path = "/get/{id}")
	public Optional<Course> FindById(@PathVariable long id) {
		
		return repo.findById(id);
	}
	
	@DeleteMapping(path = "delete/{id}")
	public void DeleteCourse(@PathVariable long id){
		
		// TODO Auto-generated constructor stub
		 repo.deleteById(id);
		 System.out.println("Deleted by id");
		 System.out.println(repo.count());
	}
	
	@PutMapping(path = "/post/{id}")
	public void UpdateCourse(@PathVariable long id,@RequestBody Course course) {
		Optional<Course> c=repo.findById(id);
		c.stream()
		.map(e->{
			 e.setName(course.getName());
			 e.setAuthor(course.getAuthor());
		return e;
		}).collect(Collectors.toList()).forEach(en -> repo.save(en));
		System.out.println("Inserted the value successfully");
	}
	
}
