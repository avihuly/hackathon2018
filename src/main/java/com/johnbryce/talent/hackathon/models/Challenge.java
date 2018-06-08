package com.johnbryce.talent.hackathon.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
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
	private int id;
	// @NotNull
	private String title;

	private String description;
	// @NotNull
	private String value;
	// @NotNull
	// @OneToOne(fetch = FetchType.EAGER, mappedBy = "id
	@OneToOne
	private User createdBy;
	@CreationTimestamp
	private LocalDateTime creationDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;

	private LocalDateTime dueDate;
	// @NotNull
	private ChallengeStatus status;
	@OneToMany(mappedBy="challenge", cascade=CascadeType.ALL)
	private List<Submission> submitters;
	@OneToMany
	private List<Comment> comments;
	// @NotNull
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;

	@Override
	public ChallengeDto mapToDto() {
		ChallengeDto map = map(ChallengeDto.class);
		if (status != null)
			map.setStatus(status);
		if (createdBy != null)
			map.setCreatedBy(createdBy.mapToDto());
		if (submitters != null)
			map.setSubmitters(submitters.stream().map(Submission::mapToDto).collect(Collectors.toList()));
		if (comments != null)
			map.setComments(comments.stream().map(Comment::mapToDto).collect(Collectors.toList()));
		map.setDifficulty(difficulty);
		return map;
	}

}
