package com.unla.Grupo6OO22022.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo6OO22022.helpers.ViewRouteHelper;
import com.unla.Grupo6OO22022.models.Usuario;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/")
	public String login() {
		
		//return "/login";	
		return ViewRouteHelper.LOGIN;
	}

	@PostMapping("/")
	public String login(@ModelAttribute("usuario") Usuario usuario) {
		
		return ViewRouteHelper.INDEX;
	}



}
