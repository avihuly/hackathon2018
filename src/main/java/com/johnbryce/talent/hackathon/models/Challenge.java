package com.johnbryce.talent.hackathon.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.johnbryce.talent.hackathon.dto.ChallengeDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Challenge extends AbstractModel {
	private static final long serialVersionUID = 7960490004473456928L;

	@Id
	@GeneratedValue
	private Long id;
	// @NotNull
	private String title;

	private String description;
	// @NotNull
	private String value;
	// @NotNull
	// @OneToOne(fetch = FetchType.EAGER, mappedBy = "id
	@OneToOne(fetch = FetchType.EAGER)
	private User createdBy;
	@CreationTimestamp
	private LocalDateTime creationDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;

	private LocalDateTime dueDate;
	// @NotNull
	private ChallengeStatus status;
	@OneToMany
	private List<User> submissions;
	@OneToMany
	private List<Comment> comments;
	// @NotNull
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;

	@Override
	public ChallengeDto mapToDto() {
		ChallengeDto map = map(ChallengeDto.class);
		if (status != null)
			map.setStatus(status.mapToDto());
		if (createdBy != null)
			map.setCreatedBy(createdBy.mapToDto());
		if (submissions != null)
			map.setSubmissions(submissions.stream().map(User::mapToDto).collect(Collectors.toList()));
		if (comments != null)
			map.setComments(comments.stream().map(Comment::mapToDto).collect(Collectors.toList()));
		map.setDifficulty(difficulty);
		return map;
	}

}
