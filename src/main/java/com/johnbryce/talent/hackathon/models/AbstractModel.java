package com.johnbryce.talent.hackathon.models;

import java.io.Serializable;

import com.johnbryce.talent.hackathon.dto.UserDto;

public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -8253895188352037117L;

	public abstract UserDto mapToDto();
}
