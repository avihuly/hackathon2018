package com.johnbryce.talent.hackathon.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.johnbryce.talent.hackathon.impl.ChallengeFilters;
import com.johnbryce.talent.hackathon.models.AbstractModel;
import com.johnbryce.talent.hackathon.models.ChallengeStatus;
import com.johnbryce.talent.hackathon.models.User;

public class ChallengeFiltersDto extends AbstractDto {
	private static final long serialVersionUID = -5936804653097872964L;

	private List<ChallengeStatusDto> statuses;
	private List<UserDto> submissions;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	@Override
	public ChallengeFilters mapToModel() {
		ChallengeFilters map = map(ChallengeFilters.class);
		map.setStatuses(statuses.stream().map(ChallengeStatusDto::mapToModel).collect(Collectors.toList()));
		map.setSubmissions(submissions.stream().map(UserDto::mapToModel).collect(Collectors.toList()));
		return map;
	}

}
