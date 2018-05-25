package com.johnbryce.talent.hackathon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.models.User;
import com.johnbryce.talent.hackathon.repository.UserRepository;

public class UserImpl implements UserFacade{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
}
