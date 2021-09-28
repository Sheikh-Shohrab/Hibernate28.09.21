package com.shohrab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shohrab.models.User;


@Controller
public class UserController {

	@GetMapping("/user/add")
	public String addCountry_GET(Model model) {
		model.addAttribute("pageTitle", "Add User");
		model.addAttribute("user", new User());
		model.addAttribute("message", "Please add a user");
		return "user/add";
	}

}
