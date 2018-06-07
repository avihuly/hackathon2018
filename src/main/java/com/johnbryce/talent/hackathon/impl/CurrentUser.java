package com.johnbryce.talent.hackathon.impl;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.johnbryce.talent.hackathon.facade.CurrentUserFacade;
import com.johnbryce.talent.hackathon.models.User;

@Component
public class CurrentUser implements CurrentUserFacade {

	private User user;
	
	private void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public User getUser() {
		return user;
	}
	
	@Override
	public Consumer<User> setUser(){
		return this::setUser;
	}
	
}
