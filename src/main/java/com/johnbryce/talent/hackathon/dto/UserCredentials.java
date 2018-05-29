package com.johnbryce.talent.hackathon.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserCredentials extends AbstractDto {

	private static final long serialVersionUID = 5155137940808296859L;

	private String username;
	private String password;

}
