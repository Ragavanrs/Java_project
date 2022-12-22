package com.validation.jpa.validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validation.jpa.validation.common.Employee;

public interface JPARepository extends JpaRepository<Employee, Integer> {

	
}
