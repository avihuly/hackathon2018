package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.Submission;
import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateSubmissionInputDto extends AbstractDto {

	private static final long serialVersionUID = -6697836368396671099L;

	private String description;
	private int submitter;
	private String submission;
	private int challengeId;

	@Override
	public Submission mapToModel() {
		Submission map = map(Submission.class);
		User user = new User();
		user.setId(submitter);
		map.setSubmitter(user);

		Challenge challenge = new Challenge();
		challenge.setId(challengeId);
		map.setChallenge(challenge);
		return map;
	}

}
