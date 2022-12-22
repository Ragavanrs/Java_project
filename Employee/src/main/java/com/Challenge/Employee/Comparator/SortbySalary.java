package com.Challenge.Employee.Comparator;

import java.util.Comparator;

import com.Challenge.Employee.common.Employee;

public class SortbySalary  implements Comparator<Employee>{



@Override
public int compare(Employee o1, Employee o2) {
	// TODO Auto-generated method stub
	if(o1.getSalary()==o2.getSalary()) {
		return 0;
	}else if (o1.getSalary()<o2.getSalary()) {
		return 1;
	}
	
	return -1;
}
}