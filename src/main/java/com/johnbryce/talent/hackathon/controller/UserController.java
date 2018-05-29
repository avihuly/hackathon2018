package com.johnbryce.talent.hackathon.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnbryce.talent.hackathon.dto.UserDto;
import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserFacade UserFacade;

	@GetMapping
	public List<UserDto> getAllUsers() {
		return UserFacade.getAllUsers().stream().map(user -> user.mapToDto()).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable int id) {
		User user = UserFacade.getUser(id);

		if (user != null) {
			return UserFacade.getUser(id).mapToDto();
		} else {
			throw new DataNotFoundException();
		}
	}

	@PostMapping
	public UserDto createUser(@RequestBody UserDto userDtoToCreate) {
		User user = UserFacade.createUser(userDtoToCreate.mapToModel());
		return user.mapToDto();
	}

}
