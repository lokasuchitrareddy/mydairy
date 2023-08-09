package com.mydairy.dao;

import java.util.List;

import com.mydairy.entities.Entry;
import com.mydairy.entities.User;

public interface UserDao
{
	public void save(User user);//Insert Query
	
	public void update(User user); //Update Query
	
	public void delete(User user);//Delete Query
	
	public User findById(int id);//Select by where clause
	
	public List<User> findAll();//select all
	
	public User findUserByName(String username);
	

}
