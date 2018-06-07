package com.johnbryce.talent.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.johnbryce.talent.hackathon.dto.DeficultyDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Deficulty extends AbstractModel {

	@Id
	private Long id;
	private String value;
	private String description;
	
	@Override
	public DeficultyDto mapToDto() {
		return map(DeficultyDto.class);
	}

}
