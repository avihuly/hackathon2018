package com.johnbryce.talent.hackathon.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnbryce.talent.hackathon.dto.ChallengeDto;
import com.johnbryce.talent.hackathon.dto.ChallengeFiltersDto;
import com.johnbryce.talent.hackathon.facade.ChallengeFacade;
import com.johnbryce.talent.hackathon.models.Challenge;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

	@Autowired
	private ChallengeFacade challengeFacade;
	
	@GetMapping("/{id}")
	public ChallengeDto getChallenge(@PathVariable Integer id) {
		return challengeFacade.getChallenge(id).mapToDto();
	}
	
	@GetMapping
	public List<ChallengeDto> getChallenges(ChallengeFiltersDto filters) {
		return challengeFacade.getChallenges(filters.mapToModel()).stream()
				.map(Challenge::mapToDto).collect(Collectors.toList());
	}
	
	@PostMapping
	public ChallengeDto createChallenge(@RequestBody ChallengeDto challenge) {
		return challengeFacade.createChallnge(challenge.mapToModel()).mapToDto();
	}
	
	@PutMapping("/{id}")
	public ChallengeDto updateChallenge(@PathVariable Integer id, @RequestBody ChallengeDto challenge) {
		challenge.setId(id);
		return challengeFacade.updateChallenge(challenge.mapToModel()).mapToDto();
	}
	
	@DeleteMapping("/{id}")
	public ChallengeDto deleteChallenge(@PathVariable Integer id) {
		return challengeFacade.deleteChallenge(id).mapToDto();
	}
	
}
