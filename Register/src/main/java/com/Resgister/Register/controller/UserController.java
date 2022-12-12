package com.Resgister.Register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Resgister.Register.User;
import com.Resgister.Register.dao.UserDao;
import com.Resgister.Register.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userservice;
	@Autowired
	UserDao userdao;
	
	@GetMapping("/")
	public String register(Model model) {
		User user =new User();
		model.addAttribute("user",user);
		return "register";
	}
    @PostMapping("/registeruser")
	public String registerUser(@ModelAttribute("user") User user) {
    	System.out.println(user);
    	userservice.registerUser(user);
		return "loginform";
	}
	
	@PostMapping("/loginform")
	public String loginUser(@ModelAttribute("user") User user) {
		
		String email=user.getEmail();
        User userdata=userdao.findByEmail(email);
		String password=user.getPassword();
		userdao.findByPassword(password);
		if(user.getEmail().equals(userdata.getEmail())) {
		return "home";
		}
		else {
			return "front";
		}
		
		
		
	}
}
