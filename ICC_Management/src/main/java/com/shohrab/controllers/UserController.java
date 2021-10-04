package com.shohrab.controllers;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shohrab.models.User;
import com.shohrab.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user/add")
	public String addUser_GET(Model model) {
		model.addAttribute("pageTitle", "Add User");
		model.addAttribute("user", new User());
		
		var genders = new HashMap<String, String>();
		genders.put("M", "Male");
		genders.put("F", "Female");
		model.addAttribute("genders", genders);
		return "user/add";
	}
	
	@PostMapping("/user/add")
	public String addUserToUserList(Model model, @ModelAttribute(name="user") User user) {
		userService.addUser(user);
		model.addAttribute("message","User added successfully");
		return "redirect:/user/show-all";
	}
	
	@GetMapping("/user/show-all")
	public String showUser(Model model) {
		model.addAttribute("pageTitle", "User List");
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("message", "Showing all users");
		return "user/show-all";
	}

}
