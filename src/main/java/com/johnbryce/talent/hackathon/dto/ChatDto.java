package com.johnbryce.talent.hackathon.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.johnbryce.talent.hackathon.models.AbstractModel;
import com.johnbryce.talent.hackathon.models.Chat;
import com.johnbryce.talent.hackathon.models.ChatComment;
import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;	

@Data
@EqualsAndHashCode(callSuper = false)
public class ChatDto extends AbstractDto {
	
	private static final long serialVersionUID = -655759171781331937L;

	private Long id;
	private List<UserDto> participants;
	private List<ChatCommentDto> comments;
	
	@Override
	public Chat mapToModel() {
		Chat map = map(Chat.class);
		map.setParticipants(participants.stream().map(UserDto::mapToModel).collect(Collectors.toList()));
		map.setComments(comments.stream().map(ChatCommentDto::mapToModel).collect(Collectors.toList()));
		return map;
	}
	
}
