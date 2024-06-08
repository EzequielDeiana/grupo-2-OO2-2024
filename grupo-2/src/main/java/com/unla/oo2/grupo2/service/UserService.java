package com.unla.oo2.grupo2.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.UserRole;
import com.unla.oo2.grupo2.repository.IUserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	private IUserRepository userRepository;

	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@SuppressWarnings("unchecked")
	public List<com.unla.oo2.grupo2.entity.User> findUsers() {
		List<com.unla.oo2.grupo2.entity.User> users = new ArrayList<com.unla.oo2.grupo2.entity.User>();
		
		users = (List<com.unla.oo2.grupo2.entity.User>) userRepository.findUsers();
		
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public List<com.unla.oo2.grupo2.entity.User> findAdmins() {
		List<com.unla.oo2.grupo2.entity.User> admins = new ArrayList<com.unla.oo2.grupo2.entity.User>();
		
		admins = (List<com.unla.oo2.grupo2.entity.User>) userRepository.findAdmins();
		
		return admins;
	}
	
	public com.unla.oo2.grupo2.entity.User findUserByUsername(String username){	
		com.unla.oo2.grupo2.entity.User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.unla.oo2.grupo2.entity.User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
	}

	private User buildUser(com.unla.oo2.grupo2.entity.User user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, grantedAuthorities);
	}

	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (UserRole userRole : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<>(grantedAuthorities);
	}
	
	
	
}