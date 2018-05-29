package com.johnbryce.talent.hackathon.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.johnbryce.talent.hackathon.facade.UserFacade;

public class UserAuthenticationManager implements AuthenticationManager {

	@Autowired
	UserFacade UserFacade;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userName = (String) authentication.getPrincipal();
		String userPassword = (String) authentication.getCredentials();

		// Need to check the userName and and password against the db

		// Spring authorities
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// SimpleGrantedAuthority adminAuthority = new
		// SimpleGrantedAuthority("ROLE_ADMIN");
		// authorities.add(adminAuthority);

		User user = new User(userName, userPassword, authorities);
		// extended User constructor
		// User user = new User(userName, userPassword, true, true, true, true,
		// authorities);

		Authentication newAuthentication = new UsernamePasswordAuthenticationToken(user, user.getAuthorities());
		return newAuthentication;
	}

}
