package com.johnbryce.talent.hackathon.models;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.johnbryce.talent.hackathon.dto.ChatDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Chat extends AbstractModel {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToMany
	// @ElementCollection
	private List<User> participants;
	
	@OneToMany(mappedBy = "chat")
	private List<ChatComment> comments;
	
	@Override
	public ChatDto mapToDto() {
		ChatDto map = map(ChatDto.class);
		map.setParticipants(participants.stream().map(User::mapToDto).collect(Collectors.toList()));
		map.setComments(comments.stream().map(ChatComment::mapToDto).collect(Collectors.toList()));
		return map;
	} 
}
