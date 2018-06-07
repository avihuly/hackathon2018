package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.UserType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserTypeDto extends AbstractDto {

	@Override
	public UserType mapToModel() {
		return map(UserType.class);
	}

}
