package com.johnbryce.talent.hackathon.facade;

import java.util.function.Consumer;

import com.johnbryce.talent.hackathon.models.User;

public interface CurrentUserFacade {

	public User getUser();

	public Consumer<User> setUser();

}
