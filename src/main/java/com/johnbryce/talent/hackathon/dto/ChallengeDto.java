package com.johnbryce.talent.hackathon.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.Difficulty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChallengeDto extends AbstractDto {
	private static final long serialVersionUID = -6011265172044993542L;

	private Long id;

	private String title;

	private String description;

	private String value;

	private UserDto createdBy;

	private LocalDateTime creationDate;

	private LocalDateTime updateDate;

	private LocalDateTime dueDate;

	private ChallengeStatusDto status;

	private List<UserDto> submissions;

	private List<CommentDto> commets;

	private Difficulty difficulty;

	@Override
	public Challenge mapToModel() {
		Challenge map = map(Challenge.class);
		if (status != null)
			map.setStatus(status.mapToModel());
		if (createdBy != null)
			map.setCreatedBy(createdBy.mapToModel());
		if (submissions != null)
			map.setSubmissions(submissions.stream().map(UserDto::mapToModel).collect(Collectors.toList()));
		if (commets != null)
			map.setComments(commets.stream().map(CommentDto::mapToModel).collect(Collectors.toList()));
		map.setDifficulty(difficulty);
		return map;
	}

}
