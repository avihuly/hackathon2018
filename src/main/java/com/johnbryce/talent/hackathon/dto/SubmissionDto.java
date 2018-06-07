package com.johnbryce.talent.hackathon.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.johnbryce.talent.hackathon.models.Submission;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SubmissionDto extends AbstractDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8228537486612175300L;

	private Long id;
	private String description;
	private UserDto submitter;
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	private List<CommentDto> comments;
	private String submission;

	@Override
	public Submission mapToModel() {
		Submission map = map(Submission.class);
		map.setSubmitter(submitter.mapToModel());
		map.setComments(comments.stream().map(CommentDto::mapToModel).collect(Collectors.toList()));
		return map;
	}

}
