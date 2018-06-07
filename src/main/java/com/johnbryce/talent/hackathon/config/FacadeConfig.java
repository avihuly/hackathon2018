package com.johnbryce.talent.hackathon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.facade.UserTypeFacade;
import com.johnbryce.talent.hackathon.impl.UserImpl;
import com.johnbryce.talent.hackathon.impl.UserTypeImpl;

@Configuration
public class FacadeConfig {

	@Bean
	public UserFacade userFacade() {
		return new UserImpl();
	}

	@Bean
	public UserTypeFacade userTypeFacade() {
		return new UserTypeImpl();
	}

}
