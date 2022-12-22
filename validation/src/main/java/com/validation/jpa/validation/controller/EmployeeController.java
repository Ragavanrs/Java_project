package com.validation.jpa.validation.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.validation.jpa.validation.Repository.JPARepository;
import com.validation.jpa.validation.common.ConfigProperties;
import com.validation.jpa.validation.common.Employee;
import com.validation.jpa.validation.comparator.Employeecompare;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@ControllerAdvice
@RestController
public class EmployeeController {

	
	JPARepository repo;
	
	
	ConfigProperties prop;
	
	
	@Autowired
	public EmployeeController(JPARepository repo, ConfigProperties prop) {
		super();
		this.repo = repo;
		this.prop = prop;
	}

	@GetMapping("/")
	public List<Employee> getEmployee() {
		List<Employee>  emp=repo.findAll();
		Collections.sort(emp, new Employeecompare());
		return emp;
	}
	
	
	@RequestMapping(value = "/post/{id}/{name}/{designation}/{salary}",method = RequestMethod.POST)
	public ResponseEntity<Employee> setname(
			@Valid @Min(20) @Max(200) @PathVariable int id,
			@Valid @Size(min = 2,max = 25) @PathVariable String name,
			@PathVariable String designation,
			@PathVariable int salary
			) {
		
		Employee emp= new Employee(id, name, designation, salary);
		this.name(id, name, designation);
		repo.save(emp);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@PostMapping("/emppost")
	public void name(@Valid @RequestBody Employee emp) {
		this.name(emp.getId(),emp.getName(),emp.getDesignation());
		repo.save(emp);
	}
	public String name(int id,String name,String author) {
		
		String accrl=prop.fcurl.concat("?id=%s&name=%s&designation=%s");
		accrl=String.format(accrl, id,name,author);
		System.out.println(accrl);
		String jsonstr;
		JSONObject js=null;
		
		//String accrl="hello  id=%s name=%s designation=%s";
		String m=String.format(accrl, id,name,author);
		return m;
		
	}
}
