package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class UserController {

	@GetMapping("/user/login")
	public ModelAndView login() {
		return new ModelAndView("/user/login");
	}

	@GetMapping("/user/logout")
	public ModelAndView logout(Model model) {
		return new ModelAndView("/user/logout");
	}

	@GetMapping("/user/loginsuccess")
	public RedirectView loginCheck() {
		return new RedirectView("/home/index");
	}

	@GetMapping("")
	public RedirectView redirectLogin() {
		return new RedirectView("/user/login");
	}

}
