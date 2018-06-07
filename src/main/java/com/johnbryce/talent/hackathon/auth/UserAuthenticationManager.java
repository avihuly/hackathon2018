package com.johnbryce.talent.hackathon.auth;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.johnbryce.talent.hackathon.facade.CurrentUserFacade;
import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.repository.UserRepository;
import com.johnbryce.talent.hackathon.utils.SecurityUtils;

public class UserAuthenticationManager implements AuthenticationManager {

	@Autowired
	UserFacade UserFacade;
	@Autowired
	CurrentUserFacade currentUserFacade;
	@Autowired
	UserRepository userRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userEmail = (String) authentication.getPrincipal();
		String userPassword = (String) authentication.getCredentials();

		boolean authenticated = false;

		// Need to check the email and and password against the db
		// ineffective as hell for now
		List<com.johnbryce.talent.hackathon.models.User> allUsers = UserFacade.getAllUsers();
		for (com.johnbryce.talent.hackathon.models.User user : allUsers) {

			if (user.getEmail().equals(userEmail)) {

				try {
					byte[] salt = user.getSalt();
					byte[] userInputPasswordByte = SecurityUtils.getHashedByteArray(userPassword, salt);
					byte[] savedPasswordByte = user.getPassword();

					if (java.util.Arrays.equals(savedPasswordByte, userInputPasswordByte)) {
						// user is authenticated!!!
						currentUserFacade.setUser().accept(userRepo.getOneByEmail(userEmail));
						authenticated = true;
					} else {
						// no need to loop any further
						break;
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (authenticated) {
			// Spring authorities
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			// SimpleGrantedAuthority adminAuthority = new
			// SimpleGrantedAuthority("ROLE_ADMIN");
			// authorities.add(adminAuthority);

			// extended User constructor
			// User user = new User(userName, userPassword, true, true, true, true,
			// authorities);
			User user = new User(userEmail, userPassword, authorities);
			return new UsernamePasswordAuthenticationToken(user, user.getAuthorities());
		} else {
			// throw exception of bad login attempt
			return null;
		}

	}

}
