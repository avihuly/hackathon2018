package com.johnbryce.talent.hackathon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnbryce.talent.hackathon.facade.CurrentUserFacade;
import com.johnbryce.talent.hackathon.facade.SubmissionFacade;
import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.Submission;
import com.johnbryce.talent.hackathon.repository.ChallengeRepository;
import com.johnbryce.talent.hackathon.repository.SubmissionRepository;

@Service
public class SubmissionImpl implements SubmissionFacade {

	@Autowired
	private SubmissionRepository submissionRepo;

	@Autowired
	private CurrentUserFacade currentUserFacade;

	@Autowired
	private ChallengeRepository challengeRepo;

	@Override
	public Submission getSubmission(int id) {
		return submissionRepo.getOne(id);
	}

	@Override
	public List<Submission> getAllSubmissions() {
		return submissionRepo.findAll();
	}

	@Override
	public Submission createSubmission(Submission submission) {

		submission.setSubmitter(currentUserFacade.getUser());
		//submission = submissionRepo.save(submission);
		Challenge challenge = challengeRepo.findById(submission.getChallenge().getId()).get();
		challenge.getSubmitters().add(submission);
		System.out.println(challenge.getSubmitters().size());
		challengeRepo.save(challenge);
		
		return submission;
	}

}
