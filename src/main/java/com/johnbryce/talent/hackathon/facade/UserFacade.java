package com.johnbryce.talent.hackathon.facade;

import java.util.List;

import com.johnbryce.talent.hackathon.models.User;

public interface UserFacade {

	public List<User> getAllUsers();

	public User getUser(int id);

	public User createUser(User user, String noneHashedPassword, int userType);

}
