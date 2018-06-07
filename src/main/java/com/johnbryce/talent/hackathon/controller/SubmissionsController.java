package com.johnbryce.talent.hackathon.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnbryce.talent.hackathon.dto.CreateSubmissionInputDto;
import com.johnbryce.talent.hackathon.dto.SubmissionDto;
import com.johnbryce.talent.hackathon.facade.SubmissionFacade;

@RestController
@RequestMapping("/submissions")
public class SubmissionsController {

	@Autowired
	private SubmissionFacade submissionFacade;

	@GetMapping("/{id}")
	public SubmissionDto getSubmission(@PathVariable Integer id) {
		return submissionFacade.getSubmission(id).mapToDto();
	}

	@GetMapping
	public List<SubmissionDto> getAllSubmissions() {
		return submissionFacade.getAllSubmissions().stream().map(submission -> submission.mapToDto())
				.collect(Collectors.toList());
	}

	@PostMapping
	public SubmissionDto createSubmission(CreateSubmissionInputDto submission) {
		return submissionFacade.createSubmission(submission.mapToModel()).mapToDto();
	}

}
