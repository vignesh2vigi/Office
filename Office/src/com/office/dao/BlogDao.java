package com.office.dao;

import java.util.List;

import com.office.model.Blog;

public interface BlogDao {

	public Blog addblog(Blog blog);
	public List<Blog> waitlist();
	
	public List<Blog> list();
	
	public Blog blogapp(int blogid);
	public Blog blogrej(int blogid);
}
