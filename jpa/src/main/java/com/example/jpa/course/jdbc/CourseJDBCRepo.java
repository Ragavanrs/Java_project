package com.example.jpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jpa.course.Course;

@Repository
public class CourseJDBCRepo {

	@Autowired
	private JdbcTemplate springjdbc;
	
	private String Insert_query="""
			insert into course (id, name, author) values (?,?,?);
			""";
	private String delete_query="""
			Delete from course where id = ? ;
			""";
	private String select_query="""
			select * from course where id = ? ;
			""";
	public void insert(Course course) {
		
		
		springjdbc.update(Insert_query,course.getId(),course.getName(),course.getAuthor());
	}
	
public void delete(long id) {
		
		
		springjdbc.update(delete_query,id);
	}

public Course selectid(long id) {
	
	
	return springjdbc.queryForObject(select_query,new 	BeanPropertyRowMapper<>(Course.class),id);
}
}
