package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.helper.RouteHelper;


@Controller
public class UserController {

	@GetMapping(RouteHelper.USER_LOGIN)
	public ModelAndView login() {
		return new ModelAndView(RouteHelper.USER_LOGIN);
	}

	@GetMapping(RouteHelper.USER_LOGOUT)
	public ModelAndView logout(Model model) {
		return new ModelAndView(RouteHelper.USER_LOGOUT);
	}

	@GetMapping(RouteHelper.USER_LOGIN_SUCCES)
	public RedirectView loginCheck() {
		return new RedirectView(RouteHelper.HOME_INDEX);
	}

	@GetMapping(RouteHelper.EMPTY)
	public RedirectView redirectLogin() {
		return new RedirectView(RouteHelper.USER_LOGIN);
	}

}
