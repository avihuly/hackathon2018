package com.johnbryce.talent.hackathon.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.johnbryce.talent.hackathon.impl.ChallengeFilters;

public class ChallengeFiltersDto extends AbstractDto {
	private static final long serialVersionUID = -5936804653097872964L;

//	private List<ChallengeStatus> statuses;
	private List<UserDto> submissions;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	@Override
	public ChallengeFilters mapToModel() {
		ChallengeFilters map = map(ChallengeFilters.class);
//		if(statuses != null)
//			map.setStatuses(statuses.stream().map(ChallengeStatus::mapToModel).collect(Collectors.toList()));
		if(submissions != null)
			map.setSubmissions(submissions.stream().map(UserDto::mapToModel).collect(Collectors.toList()));
		return map;
	}

}
