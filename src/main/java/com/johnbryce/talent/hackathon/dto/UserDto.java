package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends AbstractDto {

	private static final long serialVersionUID = 5737757742597183799L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String nickName;
	
	@Override
	public User mapToModel() { return map(User.class); }
}