package com.johnbryce.talent.hackathon.dto;

import javax.validation.constraints.NotNull;

import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends AbstractDto {

	private static final long serialVersionUID = 5737757742597183799L;

	private int id;
	@NotNull
	private String email;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;

	public User mapToModel() {
//		User user = new User();
//		user.setId(id);
//		user.setEmail(email);
//		user.setFirstName(firstName);
//		user.setLastName(lastName);
//		return user;
		return map(User.class);
	}
}
