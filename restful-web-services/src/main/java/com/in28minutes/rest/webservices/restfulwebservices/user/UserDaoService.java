package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount,"Jayanti",LocalDate.now().minusYears(28)));
		users.add(new User(++userCount,"Lata",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Padma",LocalDate.now().minusYears(49)));
		users.add(new User(++userCount,"Vinayak",LocalDate.now().minusYears(59)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User retriveOneUser(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
		
	}
	
	public void deleteUserDetails(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
	
}
