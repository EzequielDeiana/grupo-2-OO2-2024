package com.unla.oo2.grupo2.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.oo2.grupo2.entity.User;
import com.unla.oo2.grupo2.helper.RouteHelper;
import com.unla.oo2.grupo2.repository.IUserRepository;
import com.unla.oo2.grupo2.service.UserService;


@Controller
public class UserController {

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

}
