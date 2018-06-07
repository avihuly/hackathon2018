package com.johnbryce.talent.hackathon.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.models.User;
import com.johnbryce.talent.hackathon.repository.UserRepository;
import com.johnbryce.talent.hackathon.utils.SecurityUtils;

public class UserImpl implements UserFacade {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User createUser(User user, String noneHashedPassword, long userType) {
		try {
			// generate salt and hashedPasswrd(with the salt)
			byte[] salt = SecurityUtils.generateSalt();
			byte[] hashedPassword = SecurityUtils.getHashedByteArray(noneHashedPassword, salt);
			user.setSalt(salt);
			user.setPassword(hashedPassword);
			user.setUserType(userType);

			return userRepository.save(user);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// should throw exception
			return null;
		}
	}
}
