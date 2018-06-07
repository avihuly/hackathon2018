package com.johnbryce.talent.hackathon.dto;

import com.johnbryce.talent.hackathon.models.Comment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommentDto extends AbstractDto {

	@Override
	public Comment mapToModel() {
		return map(Comment.class);
	}

}
