package com.mydairy.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mydairy.dao.UserDao;
import com.mydairy.entities.User;

@Component
public class UserBusinessImplement implements UserBusiness 
{
	@Autowired
	UserDao userDao;
	@Override
	public void save(User user) 
	{
		userDao.save(user);
	}

	@Override
	public void update(User user) 
	{
		userDao.update(user);

	}

	@Override
	public void delete(User user)
	{
		userDao.delete(user);

	}

	@Override
	public User findById(int id)
	{
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() 
	{
		return userDao.findAll();
	}

	@Override
	public User findUserByName(String username) 
	{
		return userDao.findUserByName(username);
		
	}

}
