package com.prac.restfulservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDAOservice {

	public static List<User> user=new ArrayList<User>();
	public static int count=0;
	static{
		user.add(new User(++count,"ragavan",LocalDate.now().minusYears(30).minusMonths(3)));
		user.add(new User(++count,"james",LocalDate.now().minusYears(20).minusMonths(2)));
		user.add(new User(++count,"navagar",LocalDate.now().minusYears(25).minusMonths(5)));
		
	}
	
	public List<User> findAll() {
		
		return user;
	}
	
public User findone(int id) {
		
		Predicate<? super User> predicate=user -> user.getId().equals(id);
		return user.stream().filter(predicate).findFirst().orElse(null);
	}



public User create(User user1) {
	// TODO Auto-generated method stub
	user1.setId(++count);
	user.add(user1);
	return user1;
	
}

public void DeleteUser(int id) {
	// TODO Auto-generated method stub
	

	Predicate<? super User> predicate=user -> user.getId().equals(id);
	user.removeIf(predicate);
	
}
}
