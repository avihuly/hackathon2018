package com.johnbryce.talent.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.johnbryce.talent.hackathon.dto.ChallengeStatusDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ChallengeStatus extends AbstractModel {

	@Id
	@GeneratedValue
	private Long id;
	
	private String value;
	private String description;
	
	@Override
	public ChallengeStatusDto mapToDto() {
		return map(ChallengeStatusDto.class);
	}

}
