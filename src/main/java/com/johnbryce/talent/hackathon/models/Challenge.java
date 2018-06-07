package com.johnbryce.talent.hackathon.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.johnbryce.talent.hackathon.dto.ChallengeDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Challenge extends AbstractModel {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String title;
	
	private String description;
	@NotNull
	private String value;
	@NotNull
	private User createdBy;
	@CreationTimestamp
	private LocalDateTime creationDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	private LocalDateTime dueDate;
	@NotNull
	private ChallengeStatus status;
	@OneToMany
	private List<User> submissions;
	@OneToMany
	private List<Comment> commets;
	@NotNull
	private Deficulty deficulty;	
	
	
	@Override
	public ChallengeDto mapToDto() {
		ChallengeDto map = map(ChallengeDto.class);
		map.setStatus(status.mapToDto());
		map.setCreatedBy(createdBy.mapToDto());
		map.setSubmissions(submissions.stream().map(User::mapToDto).collect(Collectors.toList()));
		map.setCommets(commets.stream().map(Comment::mapToDto).collect(Collectors.toList()));
		map.setDeficulty(deficulty.mapToDto());
		return map;
	}

}
