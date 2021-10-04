package com.shohrab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shohrab.models.Players;
import com.shohrab.service.PlayerService;
import com.shohrab.service.TeamService;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/player/add")
	public String addPlayer_GET(Model model) {
		model.addAttribute("pageTitle", "Add Player");
		model.addAttribute("player", new Players());
		model.addAttribute("teams", teamService.getTeam());
		return "player/add";
	}
	
	@PostMapping("/player/add")
	public String addPlayer(RedirectAttributes redirectAttributes, 
			@ModelAttribute(name = "player") Players players,
			@RequestParam("id") int id) {
		playerService.addPlayer(players, id);
		redirectAttributes.addFlashAttribute("message", "Player added successfully");
		return "redirect:/player/show-all";
	}

	@GetMapping("/player/show-all")
	public String showAll_GET(Model model) {
		model.addAttribute("pageTitle", "Plyaer List");
		model.addAttribute("players", playerService.getPlayer());
		model.addAttribute("message", "Showing all players");
		return "player/show-all";
	}
	
	
}
