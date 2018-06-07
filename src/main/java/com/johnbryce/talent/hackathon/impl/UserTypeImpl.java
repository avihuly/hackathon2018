package com.johnbryce.talent.hackathon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnbryce.talent.hackathon.facade.UserTypeFacade;
import com.johnbryce.talent.hackathon.models.UserType;
import com.johnbryce.talent.hackathon.repository.UserTypeRepository;

public class UserTypeImpl implements UserTypeFacade {

	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public List<UserType> getAllUserTypes() {
		return userTypeRepository.findAll();
	}

	@Override
	public UserType getUserType(int id) {
		return userTypeRepository.findById(id).orElse(null);
	}
}
