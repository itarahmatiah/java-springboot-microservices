package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private int userCount = 3;
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	//List<User> findAll(){
	public List<User> findAll(){
		return users;
	}
	
	//User save(User user){
	public User save(User user){
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	//User findOne(int id){
	public User findOne(int id){
		for(User user:users) {
			if(id == user.getId()) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id){
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			User user= iter.next();
			if(id == user.getId()) {
				iter.remove();
				return user;
			}
		}
		return null;
	}
}
