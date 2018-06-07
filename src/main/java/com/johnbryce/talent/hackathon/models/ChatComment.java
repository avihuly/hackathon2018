package com.johnbryce.talent.hackathon.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.johnbryce.talent.hackathon.dto.ChatCommentDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ChatComment extends AbstractModel {

	private static final long serialVersionUID = -7513793559435340547L;

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private User author;
	
	@NotNull
	private String value;
	
	@CreationTimestamp
	private LocalDateTime creationDate;

	@Enumerated
	private ChatCommentStatus status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_id")
	private Chat chat;
	
	@Override
	public ChatCommentDto mapToDto() {
		ChatCommentDto map = map(ChatCommentDto.class);
		map.setChat(chat.mapToDto());
		return map;
	}
}
