package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.helper.RouteHelper;

@Controller
public class UserController {

	@GetMapping("/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.USER_LOGIN);
		modelAndView.addObject("error", error);
		modelAndView.addObject("logout", logout);
		return modelAndView;
	}

	@GetMapping("/loginsuccess")
	public RedirectView loginCheck() {
		return new RedirectView(RouteHelper.INDEX);
	}

	@GetMapping("/logout")
	public RedirectView logout() {
		return new RedirectView(RouteHelper.LOGOUT_SUCCESS);
	}

	@GetMapping("/logoutsuccess")
	public ModelAndView logoutSuccess() {
		return new ModelAndView(RouteHelper.USER_LOGOUT);
	}

}
