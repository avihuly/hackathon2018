package com.johnbryce.talent.hackathon.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.johnbryce.talent.hackathon.models.AbstractModel;
import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.ChallengeStatus;
import com.johnbryce.talent.hackathon.models.Comment;
import com.johnbryce.talent.hackathon.models.Deficulty;
import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChallengeDto extends AbstractDto {

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
	
	private DeficultyDto deficulty;
	
	
	@Override
	public Challenge mapToModel() {
		Challenge map = map(Challenge.class);
		map.setStatus(status.mapToModel());
		map.setCreatedBy(createdBy.mapToModel());
		map.setSubmissions(submissions.stream().map(UserDto::mapToModel).collect(Collectors.toList()));
		map.setCommets(commets.stream().map(CommentDto::mapToModel).collect(Collectors.toList()));
		map.setDeficulty(deficulty.mapToModel());
		return map;
	}

}
