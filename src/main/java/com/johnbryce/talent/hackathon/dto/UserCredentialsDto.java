package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.AbstractModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserCredentialsDto extends AbstractDto {

	private static final long serialVersionUID = 5155137940808296859L;

	private String email;
	private String password;
	
	
	@Override
	@Deprecated
	public AbstractModel mapToModel() {
		return null;
	}

}
