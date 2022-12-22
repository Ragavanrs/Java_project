package com.exercise.springboot;

import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//courses
//course : id , name , author 

@RestController
public class CourseController {
	
	

	@RequestMapping("/courses")
	public List<Course> retrieveallCourses() {
		
		return Arrays.asList(
				new Course(1,"ragavan" , "perfect smile "),
				new Course(2,"abdul" , "wings of fire"),
				new Course(3, "john" , " appritude gate " ),
				new Course(4, "raevon" , " iit " ) 
				);
		
	}
	
	
	
}
