package com.unla.Grupo6OO22022.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo6OO22022.helpers.ViewRouteHelper;
import com.unla.Grupo6OO22022.models.Usuario;


	@Controller
	public class UserController {

		@GetMapping("/login")
		public String login(Model model, 
				@RequestParam(name="error", required=false) String error,
				@RequestParam(name="logout", required=false) String logout) {
			model.addAttribute("error", error);
			model.addAttribute("logout", logout);
			return ViewRouteHelper.USER_LOGIN;
		}

		@PostMapping("/logout")
		public String logout(Model model) {
			return ViewRouteHelper.USER_LOGOUT;
		}

		@GetMapping("/loginSuccess")
		public String loginCheck(){
			return "redirect:/index";
		}
		

}
