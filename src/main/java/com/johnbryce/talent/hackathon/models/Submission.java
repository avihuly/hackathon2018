package com.johnbryce.talent.hackathon.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.johnbryce.talent.hackathon.dto.SubmissionDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Submission extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1275755736229427670L;

	@Id
	@GeneratedValue
	private int id;

	private String description;

	@OneToOne
	private User submitter;

	@OneToOne
	private Challenge challenge;

	@CreationTimestamp
	private LocalDateTime creationDate;

	@UpdateTimestamp
	private LocalDateTime updateDate;

	// @OneToMany
	@ElementCollection
	private List<Comment> comments;

	private String submission;

	@Override
	public SubmissionDto mapToDto() {

		SubmissionDto map = map(SubmissionDto.class);
		map.setSubmitter(submitter.mapToDto());
		map.setComments(comments.stream().map(Comment::mapToDto).collect(Collectors.toList()));

		return map;
	}

}
