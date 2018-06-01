package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateUserInputDto extends AbstractDto {

	private static final long serialVersionUID = -6697836368396671099L;

	private UserCredentialsDto credentials;

	private String firstName;
	private String lastName;

	public User mapToModel() {
		User user = new User();
		user.setEmail(credentials.getEmail());
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return user;
	}

}
