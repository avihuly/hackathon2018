package com.johnbryce.talent.hackathon.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateUserInputDto extends UserDto {

	private static final long serialVersionUID = -6697836368396671099L;

	private UserCredentialsDto credentials;

}
