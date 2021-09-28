package com.shohrab.service;

import java.util.ArrayList;
import java.util.List;

import com.shohrab.models.User;

public class UserService {
private List<User> userList = new ArrayList<>();
	
	public List<User> getUsers(){
		return this.userList;
	}
	
	public void addUser(User user) {
		this.userList.add(user);
	}
}
