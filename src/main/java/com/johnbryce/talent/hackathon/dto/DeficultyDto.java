package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.Deficulty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DeficultyDto extends AbstractDto {

	@Override
	public Deficulty mapToModel() {
		return map(Deficulty.class);
	}

}
