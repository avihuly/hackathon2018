package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends AbstractDto {

	private static final long serialVersionUID = 5737757742597183799L;

	private int id;
	private String email;
	private String firstName;
	private String lastName;

	public User mapToModel() {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return user;
	}
}
