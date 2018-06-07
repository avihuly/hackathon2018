package com.johnbryce.talent.hackathon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Difficulty {

	EASY("easy"),
	MEDIUM("medium"),
	HARD("hard");
	
	@Getter
	private String value;
	
}
