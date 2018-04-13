package com.office.service;

import java.util.List;

import com.office.model.Blog;

public interface BlogService {
	public Blog addblog(Blog blog);
	public List<Blog> list();
	public List<Blog> waitlist();
	public Blog blogapp(int blogid);
	public Blog blogrej(int blogid);
}
