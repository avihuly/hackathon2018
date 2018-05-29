package com.johnbryce.talent.hackathon.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnbryce.talent.hackathon.dto.UserCredentials;

@RestController
@RequestMapping("/login")
public class LoginController {

	@PostMapping
	public void login(@RequestBody UserCredentials userCredentials) {
		// Actual auth implementation is in JWTLoginFilter
		// here for proper swagger representation
	}
}
