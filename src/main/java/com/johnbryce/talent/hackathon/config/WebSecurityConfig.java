package com.johnbryce.talent.hackathon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.johnbryce.talent.hackathon.auth.UserAuthenticationManager;
import com.johnbryce.talent.hackathon.filters.JWTAuthenticationFilter;
import com.johnbryce.talent.hackathon.filters.JWTLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	UserAuthenticationManager userAuthenticationManager() {
		return new UserAuthenticationManager();
	}

	@Autowired
	UserAuthenticationManager userAuthenticationManager;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll().antMatchers(HttpMethod.POST, "/login")
				.permitAll().antMatchers(HttpMethod.POST, "/registrations/users").permitAll().anyRequest()
				.authenticated().and()
				// We filter the api/login requests
				// .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
				.addFilterBefore(new JWTLoginFilter("/login", userAuthenticationManager),
						UsernamePasswordAuthenticationFilter.class)
				// And filter other requests to check the presence of JWT in header
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Create a default account - not needed, we are not using inMemory auth
		// auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
		// User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN").build();
	}
}
