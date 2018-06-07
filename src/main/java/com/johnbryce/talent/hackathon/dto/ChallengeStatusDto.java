package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.ChallengeStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChallengeStatusDto extends AbstractDto {

	private Long id;
	
	private String value;
	private String description;
	
	@Override
	public ChallengeStatus mapToModel() {
		return map(ChallengeStatus.class);
	}

}
