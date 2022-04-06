package com.company.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.springsecurity.entity.User;
import com.company.springsecurity.service.MyUserDetailService;

@Controller
public class MainController {
	
	@Autowired
	MyUserDetailService myUserDetailService;
	
	@PostMapping("/userLogin")
	public String getUser(Model model, @RequestParam("useremail") String useremail, @RequestParam("userpassword") String userpassword) {
		
		String view = null;
		
		if(useremail != null || userpassword != null) {
			
			
		 	User user =  myUserDetailService.getUser(useremail, userpassword);
		 	
		 	if(user != null) {
	
		 		model.addAttribute("user", user);
		 		view = "welcome";
		 		
		 	}else {
		 		
				view = "error";
			}
		}else {
			view = "error";
		}
		
		return view;
	}
}
