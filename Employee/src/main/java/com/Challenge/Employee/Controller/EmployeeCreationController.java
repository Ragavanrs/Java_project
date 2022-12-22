package com.Challenge.Employee.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Challenge.Employee.Comparator.SortbySalary;
import com.Challenge.Employee.JPARepository.EmployeeJPARepository;
import com.Challenge.Employee.common.Employee;

@Controller
public class EmployeeCreationController {

	@Autowired
	private EmployeeJPARepository repo;
	
	@RequestMapping("/")
	public String Employeedetails(Model model) {
		List<Employee> l=repo.findAll();
		Collections.sort(l,new SortbySalary());
		model.addAttribute("FindAllEmployee", l);
		return "index";
	}
	
	@RequestMapping(path = "/create")
	public String GetCreated() {
		return "Employeecreation";
		
	}
	
	@RequestMapping(value ="/save",method = RequestMethod.GET)
	public String Employeedetails(Model model,@RequestParam String Keyword,@ModelAttribute Employee employee) {
		
		List<Employee> l;
		System.out.println(Keyword);
		if(Keyword!=null) {
			
			 l=repo.findByKeyword(Keyword);
			
		}else {
			repo.save(employee);
			 l=repo.findAll();
		}
		
		//List<Employee> l=repo.findAll();
		Collections.sort(l,new SortbySalary());
		model.addAttribute("FindAllEmployee", l);
		return "index";
	}
	
}
