package com.johnbryce.talent.hackathon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

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

	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10000);
		filter.setIncludeHeaders(false);
		filter.setAfterMessagePrefix("REQUEST DATA : ");
		return filter;
	}
}
