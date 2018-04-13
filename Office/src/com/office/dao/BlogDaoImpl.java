package com.office.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import com.office.model.Blog;

public class BlogDaoImpl implements BlogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Override
	public Blog addblog(Blog blog) {
		// TODO Auto-generated method stub
		Blog dealerRegLoginOutObj = new Blog();
		try {
			
			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO blog (title,content,postby) VALUES (?,?,?)";

			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { 
							blog.getTitle(),
							blog.getContent(),
							blog.getPostby()
							});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				
			} else {
				dealerRegLoginOutObj.setStatus(false);
				
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			
		}

		return dealerRegLoginOutObj;
	}
	@Override
	public List<Blog> list() {
		// TODO Auto-generated method stub
		Blog custVehiDetailsOutObj = new Blog();
        List<Blog> custDetailsList = new ArrayList<Blog>();
		String pendingQuery = "SELECT blogid,title,content,postby,date FROM blog where status='1'";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,
					new BeanPropertyRowMapper(Blog.class));
			
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			
		}
		return custDetailsList;
	}
	
	@Override
	public List<Blog> waitlist() {
		Blog custVehiDetailsOutObj = new Blog();
        List<Blog> custDetailsList = new ArrayList<Blog>();
		String pendingQuery = "SELECT blogid,title,content,postby,date FROM blog where status='0'";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,
					new BeanPropertyRowMapper(Blog.class));
			
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			
		}
		return custDetailsList;
	}
	@Override
	public Blog blogapp(int blogid) {
		// TODO Auto-generated method stub
		Blog del = new Blog();
		try {
			
			int insertDealerReg_int = 0;
			
			String Query="update blog set status='1' WHERE blogid=?";
			insertDealerReg_int=this.jdbcTemplate.update(Query,new Object[] { blogid});
			System.out.println("deal====="+Query);
			if (insertDealerReg_int > 0) {
				del.setStatus(true);
				
			} else {
				del.setStatus(false);
				
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return del;
	}
	@Override
	public Blog blogrej(int blogid) {
		// TODO Auto-generated method stub
		Blog del = new Blog();
		try {
			
			int insertDealerReg_int = 0;
			
			String Query="DELETE FROM blog WHERE blogid=?";
			insertDealerReg_int=this.jdbcTemplate.update(Query,new Object[] { blogid});
			System.out.println("deal====="+Query);
			if (insertDealerReg_int > 0) {
				del.setStatus(true);
				
			} else {
				del.setStatus(false);
				
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return del;
	}

	

}
