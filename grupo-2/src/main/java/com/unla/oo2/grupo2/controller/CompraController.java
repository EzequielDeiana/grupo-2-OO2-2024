package com.unla.oo2.grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.helper.RouteHelper;

@Controller
@RequestMapping("/compra")
public class CompraController {
	
	@GetMapping("/index")
	public ModelAndView index() {
		
		return new ModelAndView(RouteHelper.COMPRA_INDEX);
		
	}

	@GetMapping("/")
	public RedirectView redirectHome() {
		
		return new RedirectView(RouteHelper.INDEX);
		
	}

}