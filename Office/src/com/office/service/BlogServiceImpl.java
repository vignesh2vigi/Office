package com.office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.office.dao.BlogDao;
import com.office.model.Blog;

public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDao;
	
	@Override
	public Blog addblog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.addblog(blog);
	}

	@Override
	public List<Blog> list() {
		// TODO Auto-generated method stub
		return blogDao.list();
	}

	@Override
	public List<Blog> waitlist() {
		// TODO Auto-generated method stub
		return blogDao.waitlist();
	}

	@Override
	public Blog blogapp(int blogid) {
		// TODO Auto-generated method stub
		return blogDao.blogapp(blogid);
	}

	@Override
	public Blog blogrej(int blogid) {
		// TODO Auto-generated method stub
		return blogDao.blogrej(blogid);
	}



}
