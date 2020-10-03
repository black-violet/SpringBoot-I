package com.maria.examen1.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.maria.examen1.models.Tvshow;
import com.maria.examen1.models.User;
import com.maria.examen1.services.RaitingService;
import com.maria.examen1.services.TvshowService;
import com.maria.examen1.services.UserService;

@Controller

public class TvshowController {
	
	private UserService userService;
	private TvshowService tvService;
	private RaitingService raitingService;
	
	public TvshowController(UserService userService, TvshowService tvService, RaitingService raitingService) {
		this.userService = userService;
		this.tvService = tvService;
		this.raitingService = raitingService;
	}
	
	@RequestMapping("/shows/new")
	public String createShow(@ModelAttribute("tvshow") Tvshow tvshow,Model model) {
		List<User> user = userService.allUsers();
		model.addAttribute("user", user);
		return "createshow.jsp";
	}
	
	@RequestMapping(value="/shows/new", method=RequestMethod.POST)
	public String createSubmit(@Valid @ModelAttribute("tvshow") Tvshow tvshow, Principal principal, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "createshow.jsp";
		}else {
			 Long userid= ((User) principal).getId();
	            User user = userService.findUserById(userid);
	            tvshow.setCreator(user);
	            List<User> u = new ArrayList<User>();
	            u.add(user);
	            tvshow.setQualifyingUser(u);
				tvService.create(tvshow);
				Long id = tvshow.getCreator().getId();
				return "redirect:/shows" + id; 
		}
	}
	@RequestMapping("shows/{id}")
	public String displayShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		Tvshow myShow = tvService.findById(id);
		model.addAttribute("show", myShow);
		
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		Tvshow tv = tvService.findTvShow(id);
		u.getShows().add(tv);
		userService.updateUser(u);
	
		return "showInfo.jsp";
	}
}
