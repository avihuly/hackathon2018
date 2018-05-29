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

		// will return 200 with an Authorization header.
		// for example:
		// Bearer
		// eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkb3IiLCJleHAiOjE1Mjg0ODkyMDh9.5MSThv67bWPiVKjJpV91tz_1oex55nVG1ryW1cuZbLWnFS8l1EJI1FWHpp8lQ9ACMgHLxbY6UjeuC3JL44T1lg
	}
}
