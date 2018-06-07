package com.johnbryce.talent.hackathon.models;

import com.johnbryce.talent.hackathon.dto.AbstractDto;
import com.johnbryce.talent.hackathon.dto.CommentDto;

public class Comment extends AbstractModel {

	@Override
	public CommentDto mapToDto() {
		return map(CommentDto.class);
	}

}
