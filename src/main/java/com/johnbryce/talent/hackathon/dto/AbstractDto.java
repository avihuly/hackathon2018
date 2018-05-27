package com.johnbryce.talent.hackathon.dto;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.johnbryce.talent.hackathon.models.AbstractModel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractDto implements Serializable {
	
	private static final long serialVersionUID = 1511265750278467904L;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private static ModelMapper mm;
	
	static {
		mm = new ModelMapper();
		mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	public abstract AbstractModel mapToModel();
	
	public <T extends AbstractModel> T map(Class<T> clazz) { return (T) mm.map(this, clazz); }
	
}
