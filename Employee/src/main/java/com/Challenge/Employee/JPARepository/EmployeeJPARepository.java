package com.Challenge.Employee.JPARepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Challenge.Employee.common.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findById(int id);
	
	@Query(value = "select * from employee where name like %:keyword%  or designation like %:keyword%  ",nativeQuery = true)
	public List<Employee> findByKeyword(@Param("keyword") String keyword) ;
}
