package com.Challenge.Employee.Controller;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Challenge.Employee.Comparator.SortbySalary;
import com.Challenge.Employee.JPARepository.EmployeeJPARepository;
import com.Challenge.Employee.common.Employee;

@Validated
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeJPARepository repo;
	
//	@RequestMapping("/")
//	public String Employeedetails(Model model) {
//		List<Employee> l=repo.findAll();
//		Collections.sort(l,new SortbySalary());
//		model.addAttribute("FindAllEmployee", l);
//		return "index";
//	}

	@GetMapping("/GetEmployee")
	public List<Employee> FindAllEmployee(){
		List<Employee> l=repo.findAll();
		Collections.sort(l,new SortbySalary());
		for (Employee emp:l) {
			System.out.println(emp);
		}
		
		return l;
		
	}
	
	@PostMapping(path="/Post")
	public void insertEmployee(@RequestBody Employee employee) {
		String S=this.name(employee.getId(),employee.getName(),employee.getDesignation());
		System.out.println(S);
		repo.save(employee);
		
	}
	
	@PostMapping(path="/Post/{id}/{name}/{designation}/{salary}")
	public void insertEmployeed(
@Valid @Min(value=20) @PathVariable int id,
@Valid @Size(min=1,max=12) @PathVariable String name,
@Valid @Size(min=1,max=12) @PathVariable String designation,
@PathVariable int salary
			) {
		String S=this.name(id,name,designation);
		Employee employee=new Employee(id,name,designation,salary);
		System.out.println(S);
		repo.save(employee);
		
	}
	
	@GetMapping(path = "/GetEmployee/{id}")
	public List<Employee> FindParticularEmployeeById(@PathVariable int id){
		List<Employee> l=repo.findById(id);
		//Collections.sort(l,new SortbySalary());
		return l;
		
	}
	
	public String name(int id,String name,String author) {
		String accrl="hello  id=%s name=%s designation=%s";
		String m=String.format(accrl, id,name,author);
		return m;
		
	}
	
}
