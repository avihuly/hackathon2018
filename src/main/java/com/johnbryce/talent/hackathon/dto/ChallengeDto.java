package com.johnbryce.talent.hackathon.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.ChallengeStatus;
import com.johnbryce.talent.hackathon.models.Difficulty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChallengeDto extends AbstractDto {
	private static final long serialVersionUID = -6011265172044993542L;

	private int id;

	private String title;

	private String description;

	private String value;

	private UserDto createdBy;

	private LocalDateTime creationDate;

	private LocalDateTime updateDate;

	private LocalDateTime dueDate;

	private ChallengeStatus status;

	private List<SubmissionDto> submitters;

	private List<CommentDto> comments;

	private Difficulty difficulty;

	@Override
	public Challenge mapToModel() {
		Challenge map = map(Challenge.class);
		if (status != null)
			map.setStatus(status);
		if (createdBy != null)
			map.setCreatedBy(createdBy.mapToModel());
		if (submitters != null)
			map.setSubmitters(submitters.stream().map(SubmissionDto::mapToModel).collect(Collectors.toList()));
		if (comments != null)
			map.setComments(comments.stream().map(CommentDto::mapToModel).collect(Collectors.toList()));
		map.setDifficulty(difficulty);
		return map;
	}


}
