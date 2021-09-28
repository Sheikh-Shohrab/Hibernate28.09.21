package com.shohrab.controllers;

import org.springframework.stereotype.Controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shohrab.models.Team;


@Controller
public class TeamController {
	
	@GetMapping("/team/add")
	public String home(Model model) {
		model.addAttribute("pageTitle", "Add Team");
		model.addAttribute("team", new Team());
		model.addAttribute("message", "Please add a team");
		return "team/add";
	}
}
