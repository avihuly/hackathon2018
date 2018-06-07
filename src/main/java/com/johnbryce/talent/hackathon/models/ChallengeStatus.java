package com.johnbryce.talent.hackathon.models;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.johnbryce.talent.hackathon.dto.ChallengeStatusDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ChallengeStatus extends AbstractModel {
	
	@Id
	private int id;
	private String value;
	private String description;
	
	public static Supplier<ChallengeStatus> NEW = () -> new ChallengeStatus();
	public static Supplier<ChallengeStatus> DELETED = () -> new ChallengeStatus();
	public static BiPredicate<ChallengeStatus, ChallengeStatus> flowCheck = (currentStatus, newStatus) -> {return true;};
	
	@Override
	public ChallengeStatusDto mapToDto() {
		return map(ChallengeStatusDto.class);
	}

}
