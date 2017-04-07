package com.bookwebsystem.dao;

import com.bookwebsystem.model.User;

public interface UserDao {

	public User getByUserName(String userName);
	
	public void addUser(User user);
}
