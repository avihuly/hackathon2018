package com.johnbryce.talent.hackathon.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.johnbryce.talent.hackathon.dto.AbstractDto;
import com.johnbryce.talent.hackathon.models.AbstractModel;
import com.johnbryce.talent.hackathon.models.ChallengeStatus;
import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChallengeFilters extends AbstractModel{
	private static final long serialVersionUID = 729175743220411858L;
	
	private List<ChallengeStatus> statuses;
	private List<User> submissions;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	@Override
	public AbstractDto mapToDto() {
		// TODO Auto-generated method stub
		return null;
	}

}
