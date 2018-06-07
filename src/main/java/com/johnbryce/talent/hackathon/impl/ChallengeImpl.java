package com.johnbryce.talent.hackathon.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnbryce.talent.hackathon.controller.DataNotFoundException;
import com.johnbryce.talent.hackathon.exception.StatusFlowException;
import com.johnbryce.talent.hackathon.facade.ChallengeFacade;
import com.johnbryce.talent.hackathon.facade.CurrentUserFacade;
import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.ChallengeStatus;
import com.johnbryce.talent.hackathon.repository.ChallengeRepository;


@Service
public class ChallengeImpl implements ChallengeFacade {
	@Autowired
	private CurrentUserFacade userFacade;
	
	@Autowired
	private ChallengeRepository challengeRepo;
	
	@Override
	public Challenge getChallenge(Long id) {
		return challengeRepo.getOne(id);
	}

	@Override
	public List<Challenge> getChallenges(ChallengeFilters filters) {
		return challengeRepo.findAllChallengeBycreatedBy(userFacade.getUser());
	}

	@Override
	public List<Challenge> getChallenges() {
		return challengeRepo.findAllChallengeBycreatedBy(userFacade.getUser());
	}
	
	@Override
	@Transactional
	public Challenge createChallnge(Challenge challenge) {
		challenge.setCreatedBy(userFacade.getUser());
		challenge.setStatus(ChallengeStatus.NEW.get());
		Challenge save = challengeRepo.save(challenge);
		return save;
	}

	@Override
	@Transactional
	public Challenge updateChallenge(Challenge challenge) {
		Challenge current = challengeRepo.findById(challenge.getId()).orElseThrow(() -> new DataNotFoundException());
		
		if(! ChallengeStatus.flowCheck.test(current.getStatus(), challenge.getStatus())) {
			throw new StatusFlowException();
		}
		current = challengeRepo.save(current);
		return current;
	}

	@Override
	@Transactional
	public Challenge deleteChallenge(Long id) {
		Challenge current = challengeRepo.getOne(id);
		if(! ChallengeStatus.flowCheck.test(current.getStatus(), ChallengeStatus.DELETED.get())) {
			throw new StatusFlowException();
		}
		current.setStatus(ChallengeStatus.DELETED.get());
		return current;
	}

}
