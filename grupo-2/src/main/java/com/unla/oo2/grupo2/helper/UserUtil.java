package com.unla.oo2.grupo2.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.unla.oo2.grupo2.entity.User;
import com.unla.oo2.grupo2.service.UserService;

public class UserUtil {

	private static UserService userService;

	public UserUtil(UserService userService) {
		this.userService = userService;
	}

	public static User getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}

		Object principal = authentication.getPrincipal();
		String username = null;

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		try {
			return userService.findUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
