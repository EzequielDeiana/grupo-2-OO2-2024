package com.unla.oo2.grupo2.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.unla.oo2.grupo2.entity.User;
import com.unla.oo2.grupo2.entity.UserRole;
import com.unla.oo2.grupo2.service.UserService;

@Component
public class UserUtil {
	
	public static String ROLE_ADMIN = "ROLE_ADMIN";
	public static String ROLE_USER = "ROLE_USER";

	private static UserService userService = null;

	@SuppressWarnings("static-access")
	public UserUtil(UserService userService) {
		this.userService = userService;
	}

	public static User getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			System.out.println("Authentication is null or not authenticated");
			return null;
		}

		Object principal = authentication.getPrincipal();
		String username;

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		try {
			User user = userService.findUserByUsername(username);
			if (user == null) {
				System.out.println("User not found with username: " + username);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isAdmin() {
		User user = getUser();

		if (user == null) {
			System.out.println("User is null in isAdmin check");
			return false;
		}

		boolean isAdmin = false;
		
		for(UserRole rol : user.getUserRoles()) {
			if(rol.toString().equalsIgnoreCase("ROLE_ADMIN")) {
				isAdmin = true;
			}
		}

		return isAdmin;
	}
	
	public static boolean isRol(String rol) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(rol));
	}
}
