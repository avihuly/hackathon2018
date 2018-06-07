package com.johnbryce.talent.hackathon.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.johnbryce.talent.hackathon.models.AbstractModel;
import com.johnbryce.talent.hackathon.models.ChatComment;
import com.johnbryce.talent.hackathon.models.ChatCommentStatus;
import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChatCommentDto extends AbstractDto {
	
	private Long id;
	private String author;
	private String value;
	private LocalDateTime creationDate;
	private ChatCommentStatus status;
	private ChatDto chat;
	
	@Override
	public ChatComment mapToModel() {
		ChatComment map = map(ChatComment.class);
		map.setChat(chat.mapToModel());
		return map;
	}

}
