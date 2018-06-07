package com.johnbryce.talent.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnbryce.talent.hackathon.dto.ChallengeDto;
import com.johnbryce.talent.hackathon.facade.ChallengeFacade;

@RestController
@RequestMapping("/challenge")
public class challengeController {

	@Autowired
	private ChallengeFacade ChallengeFacade;
	
	@GetMapping("/{id}")
	public ChallengeDto getChallenge(@PathVariable Long id) {
		return ChallengeFacade.getChallenge(id).mapToDto();
	}
	
}
