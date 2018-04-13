package com.office.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.office.dao.UserDao;
import com.office.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return userDao.register(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public boolean valid(String name) {
		// TODO Auto-generated method stub
		return userDao.valid(name);
	}

	@Override
	public boolean validpass(String password) {
		// TODO Auto-generated method stub
		return userDao.validpass(password);
	}

	@Override
	public User uploadProfilePic(User profilePicture) {
		// TODO Auto-generated method stub
		return userDao.uploadProfilePic(profilePicture);
	}

	@Override
	public User getProfilePic(String name) {
		// TODO Auto-generated method stub
		return userDao.getProfilePic(name);
	}

}
