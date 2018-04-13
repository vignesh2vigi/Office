package com.office.controller;


import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.office.model.Error;
import com.office.model.User;
import com.office.service.UserService;
@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
@RequestMapping(value = "/Registration", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
 	public ResponseEntity<User> dealerRegistration(@RequestBody User user) {
		System.out.println("user register");
		User dealerRegLoginObj = userService.register(user);
		return new ResponseEntity<User>(dealerRegLoginObj,HttpStatus.OK);
	}

@RequestMapping(value="/login",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> login(@RequestBody User user, HttpSession session){
	if(!userService.valid(user.getName())){	
		Error error=new Error(2,"Invalid name");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	}
	else if(!userService.validpass(user.getPassword())){	
		Error error=new Error(3,"Invalid  Password");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	}
	User validUser= userService.login(user);
	
	session.setAttribute("name", validUser.getName());
	return new ResponseEntity<User>(validUser,HttpStatus.OK);	
}
@RequestMapping(value = "/logout", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> logout(HttpSession session){
	String admin_username=(String)session.getAttribute("name");
	System.out.println("Name of the user is"+ admin_username);
	if(admin_username==null){
		return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
	}
	session.removeAttribute("name");
	session.invalidate();
	return new ResponseEntity<User>(HttpStatus.OK);
}

@RequestMapping(value="/uploadprofilepic",method=RequestMethod.POST)
public ResponseEntity<?> uploadProfilePic(@RequestParam("image") MultipartFile file,HttpSession session){
	String name2=(String)session.getAttribute("name");
	System.out.println(""+name2);
	 User profilePicture=new User();
	 profilePicture.setName(name2);
	 
	try {
		profilePicture.setImage(file.getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 userService.uploadProfilePic(profilePicture);
	 return new ResponseEntity<User>(profilePicture,HttpStatus.OK);
}

@RequestMapping(value="/getimage/{name}",method=RequestMethod.GET)
public @ResponseBody byte[] getProfilePicture(@PathVariable String name,HttpSession session){
	System.out.println("image");
	 User profilePicture= userService.getProfilePic(name);
	 if(profilePicture==null)
		 return null;
	 else
		 return profilePicture.getImage();
}

}
