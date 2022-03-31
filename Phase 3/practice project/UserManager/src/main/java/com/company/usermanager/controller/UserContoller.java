package com.company.usermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.usermanager.dao.UserManagerDAO;
import com.company.usermanager.entity.User;

@Controller
public class UserContoller {

	@Autowired
	UserManagerDAO userManagerDAO;
	
	@PostMapping("/searchUser")
	public String getUser(Model model, @RequestParam("id") String id) {
		
		String view = null;
		
		if(id != null) {
		
			int ID = Integer.parseInt(id);	
			User userDetails = userManagerDAO.getUserDetails(ID);
		
			if(userDetails != null) {
				model.addAttribute("userDetails", userDetails);
				view = "getDetails";
			
		    }else {
		    	
		    	view = "error";
		  }	
			
		}else {
			
			view = "error";
		}
		
		return view;
	}
	
	@PostMapping("/updateUser")
	public String updateUser(Model model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
		
		User user = new User();
		
		int ID = Integer.parseInt(id);	
		
		user.setUserid(ID);
		user.setUsername(name);
		user.setUseremail(email);
		user.setUserpassword(password);
		
		userManagerDAO.updateUserDetails(user);	
		
		return "successfulUpdate";
	}

}
