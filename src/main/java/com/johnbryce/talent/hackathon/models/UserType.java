package com.johnbryce.talent.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.johnbryce.talent.hackathon.dto.UserTypeDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class UserType extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 915972301465392346L;

	@Id
	private int id;
	private String value;

	@Override
	public UserTypeDto mapToDto() {
		return map(UserTypeDto.class);
	}

}
