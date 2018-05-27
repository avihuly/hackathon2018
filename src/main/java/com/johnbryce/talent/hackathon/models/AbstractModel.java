package com.johnbryce.talent.hackathon.models;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.johnbryce.talent.hackathon.dto.AbstractDto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -8253895188352037117L;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private static ModelMapper mm;
	
	static {
		mm = new ModelMapper();
		mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	public abstract AbstractDto mapToDto();
	
	public <T extends AbstractDto> T map(Class<T> clazz) { return (T) mm.map(this, clazz); }
}
