package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.helper.RouteHelper;
import com.unla.oo2.grupo2.helper.UserUtil;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(RouteHelper.HOME_INDEX);
		modelAndView.addObject("isAdmin", UserUtil.isAdmin());
		return modelAndView;
	}

	@GetMapping("/")
	public RedirectView redirectHome() {
		return new RedirectView(RouteHelper.INDEX);
	}

}
