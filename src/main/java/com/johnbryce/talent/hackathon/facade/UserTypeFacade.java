package com.johnbryce.talent.hackathon.facade;

import java.util.List;

import com.johnbryce.talent.hackathon.models.UserType;

public interface UserTypeFacade {

	public List<UserType> getAllUserTypes();

	public UserType getUserType(int id);

}
