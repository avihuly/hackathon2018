package com.johnbryce.talent.hackathon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnbryce.talent.hackathon.facade.SubmissionFacade;
import com.johnbryce.talent.hackathon.facade.UserFacade;
import com.johnbryce.talent.hackathon.models.Submission;
import com.johnbryce.talent.hackathon.models.User;
import com.johnbryce.talent.hackathon.repository.SubmissionRepository;

@Service
public class SubmissionImpl implements SubmissionFacade {

	@Autowired
	private SubmissionRepository submissionRepo;

	@Autowired
	private UserFacade userFacade;

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
		// get the owner of the submission
		User user = userFacade.getUser(submission.getSubmitter().getId());
		submission.setSubmitter(user);

		submissionRepo.save(submission);
		return null;
	}

}
