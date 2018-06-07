package com.johnbryce.talent.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnbryce.talent.hackathon.dto.CreateUserInputDto;
import com.johnbryce.talent.hackathon.dto.UserDto;
import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.models.User;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

	private final int USER_TYPE_USER_ID = 1;

	@Autowired
	UserFacade UserFacade;

	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserDto createUser(@RequestBody CreateUserInputDto userDtoToCreate) {
		User user = UserFacade.createUser(userDtoToCreate.mapToModel(), userDtoToCreate.getCredentials().getPassword(),
				USER_TYPE_USER_ID);
		return user.mapToDto();
	}
}
