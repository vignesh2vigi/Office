package com.office.service;

import java.util.List;

import com.office.model.User;

public interface UserService {
	public User register(User user);
	public User login(User user);
	 public boolean valid(String name);
	   public boolean validpass(String password);
	   public User uploadProfilePic (User profilePicture);
	   public User getProfilePic(String name);
	   public List<User>user();
	   public User friend(int sno);
}
