package com.unla.Grupo6OO22022.controllers;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo6OO22022.helpers.ViewRouteHelper;
import com.unla.Grupo6OO22022.models.Usuario;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView(ViewRouteHelper.LOGIN);
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mv.addObject("username", usuario.getNombre());
		mv.addObject("usuario", usuario);
		return mv ;
	}

	@PostMapping("/")
	public String autenticate(@ModelAttribute("usuario") Usuario usuario) {
		System.out.println(usuario.toString());
		return ViewRouteHelper.INDEX;
	}



}
