package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.Difficulty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DifficultyDto extends AbstractDto {

	@Override
	public Difficulty mapToModel() {
		return map(Difficulty.class);
	}

}
