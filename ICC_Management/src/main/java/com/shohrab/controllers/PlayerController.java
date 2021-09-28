package com.shohrab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shohrab.models.Players;

@Controller
public class PlayerController {
	
	@GetMapping("player/add")
	public String home(Model model) {
		model.addAttribute("pageTitle", "Add Player");
		model.addAttribute("player", new Players());
		model.addAttribute("message", "Please add a player");
		return "player/add";
	}
}
