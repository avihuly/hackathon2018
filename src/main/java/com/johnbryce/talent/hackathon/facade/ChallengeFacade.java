package com.johnbryce.talent.hackathon.facade;

import java.util.List;

import com.johnbryce.talent.hackathon.impl.ChallengeFilters;
import com.johnbryce.talent.hackathon.models.Challenge;

public interface ChallengeFacade {

	public Challenge getChallenge(Long id);
	
	public List<Challenge> getChallenges(ChallengeFilters filters);
	
	public Challenge createChallnge(Challenge challenge);
	
	public Challenge updateChallenge(Challenge challenge);
	
	public Challenge deleteChallenge(Long id);

	public List<Challenge> getChallenges();
	
}
