package com.johnbryce.talent.hackathon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnbryce.talent.hackathon.facade.ChallengeFacade;
import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.repository.ChallengeRepository;


@Service
public class ChallengeImpl implements ChallengeFacade {

	@Autowired
	private ChallengeRepository challengeRepo;
	
	@Override
	public Challenge getChallenge(Long id) {
		return challengeRepo.getOne(id);
	}

	@Override
	public List<Challenge> getChallenges(ChallengeFilters filters) {
		return challengeRepo.findAll();
	}

	@Override
	public Challenge createChallnge(Challenge challenge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Challenge updateChallenge(Challenge challenge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Challenge deleteChallenge(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
