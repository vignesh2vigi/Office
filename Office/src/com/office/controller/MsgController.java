package com.office.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.office.model.Msg;
import com.office.service.MsgService;

@Controller
public class MsgController {
	@Autowired
	private MsgService msgService;
	
	@RequestMapping(value = "/addmsg2", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
 	public ResponseEntity<Msg> addblog(@RequestBody Msg msg,HttpSession session) {
		System.out.println("user register");
		Msg dealerRegLoginObj = new Msg();
		System.out.println("check");
		String from=(String)session.getAttribute("name");
		msg.setFrom(from);
		
		 msgService.addmsg(msg);
		 
		return new ResponseEntity<Msg>(dealerRegLoginObj,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getmsg", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
 	public ResponseEntity<List<Msg>> getmsg(HttpSession session) {
		System.out.println("user register");
		Msg msg = new Msg();
		System.out.println("check");
	String from=(String)session.getAttribute("name");
		msg.setFrom(from);
		
		List<Msg> msg1 = msgService.getmsg(msg);
		 
		return new ResponseEntity<List<Msg>>(msg1,HttpStatus.OK);
	}
}
