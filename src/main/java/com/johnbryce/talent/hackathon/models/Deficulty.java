package com.johnbryce.talent.hackathon.models;

import com.johnbryce.talent.hackathon.dto.DeficultyDto;

public class Deficulty extends AbstractModel {

	@Override
	public DeficultyDto mapToDto() {
		return map(DeficultyDto.class);
	}

}
