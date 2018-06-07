package com.johnbryce.talent.hackathon.facade;

import java.util.List;

import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.Submission;

public interface SubmissionFacade {

	public Submission getSubmission(Long id);

	public List<Submission> getAllSubmissions();

	public Submission createSubmission(Submission submission);

}
