package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.helper.RouteHelper;


@Controller
public class UserController {

	@GetMapping("/login")
	public ModelAndView login(@RequestParam(name="error",required=false) String error, @RequestParam(name="logout", required=false) String logout) {
		ModelAndView model = new ModelAndView(RouteHelper.USER_LOGIN);
		model.addObject("error", error);
		model.addObject("logout", logout);
		return model;
	}

	@GetMapping("/logout")
	public ModelAndView logout(ModelAndView model) {
		model.setViewName(RouteHelper.USER_LOGOUT);
		return model;
	}

	@GetMapping("/loginsuccess")
	public RedirectView loginCheck() {
		return new RedirectView(RouteHelper.INDEX);
	}

	/* 
	  @GetMapping(RouteHelper.USER_LOGIN)
	public String login(Model model, @RequestParam(name="error",required=false) String error, @RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return RouteHelper.USER_LOGIN;
	}

	@GetMapping(RouteHelper.USER_LOGOUT)
	public String logout(Model model) {
		return RouteHelper.USER_LOGOUT;
	}

	@GetMapping(RouteHelper.USER_LOGIN_SUCCES)
	public RedirectView loginCheck() {
		return new RedirectView(RouteHelper.HOME_INDEX);
	}

	@GetMapping(RouteHelper.EMPTY)
	public RedirectView redirectLogin() {
		return new RedirectView(RouteHelper.USER_LOGIN);
	}
	 */

}
