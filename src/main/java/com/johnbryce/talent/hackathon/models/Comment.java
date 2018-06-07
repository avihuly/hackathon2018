package com.johnbryce.talent.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.johnbryce.talent.hackathon.dto.CommentDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment extends AbstractModel {

	@Id
	@GeneratedValue
	private Long id;
	
	
	
	@Override
	public CommentDto mapToDto() {
		return map(CommentDto.class);
	}

}
