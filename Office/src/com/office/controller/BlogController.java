package com.office.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.office.model.Blog;
import com.office.model.Error;
import com.office.service.BlogService;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "/addblog", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
 	public ResponseEntity<Blog> addblog(@RequestBody Blog blog,HttpSession session) {
		System.out.println("user register");
		Blog dealerRegLoginObj = new Blog();
		String admin_id=(String)session.getAttribute("name");
		
		blog.setPostby(admin_id);
		 blogService.addblog(blog);
		 
		return new ResponseEntity<Blog>(dealerRegLoginObj,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getblog",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list(HttpSession session){
		String admin_username=(String)session.getAttribute("name");
		 if(admin_username==null){	
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		 List<Blog> list=blogService.list();
		 return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
}
	@RequestMapping(value="/waitlist",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> waitlist(HttpSession session){
		/*String admin_username=(String)session.getAttribute("name");
		 if(admin_username==null){	
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}*/
		 List<Blog> list=blogService.waitlist();
		 return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
}
	
	
	@RequestMapping(value = "/blogapp/{blogid}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
 	public ResponseEntity<Blog> blogapp(@PathVariable int blogid,HttpSession session) {
		System.out.println("user register");
		Blog dealerRegLoginObj = blogService.blogapp(blogid);
		return new ResponseEntity<Blog>(dealerRegLoginObj,HttpStatus.OK);
	}
	@RequestMapping(value = "/blogrej/{blogid}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
 	public ResponseEntity<Blog> blogrej (@PathVariable int blogid,HttpSession session) {
		System.out.println("user register");
		Blog dealerRegLoginObj = blogService.blogrej(blogid);
		 
		return new ResponseEntity<Blog>(dealerRegLoginObj,HttpStatus.OK);
	}
	
	
	
}
