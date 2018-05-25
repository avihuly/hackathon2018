package com.johnbryce.talent.hackathon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.impl.UserImpl;

@Configuration
public class FacadeConfig {

	@Bean
	public UserFacade userFacade() {
		return new UserImpl();
	}
	
}
