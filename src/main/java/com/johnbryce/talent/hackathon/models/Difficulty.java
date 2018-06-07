package com.johnbryce.talent.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.johnbryce.talent.hackathon.dto.DifficultyDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Difficulty extends AbstractModel {

	@Id
	private Long id;
	private String value;
	private String description;
	
	@Override
	public DifficultyDto mapToDto() {
		return map(DifficultyDto.class);
	}

}
