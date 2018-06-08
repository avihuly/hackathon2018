package com.johnbryce.talent.hackathon.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.johnbryce.talent.hackathon.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends AbstractDto {

	private static final long serialVersionUID = 5737757742597183799L;

	private int id;
	@NotNull
	private String email;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;

//	private List<ChatDto> chats;
	
	public User mapToModel() {
		User map = map(User.class);
//		map.setChats(chats.stream().map(ChatDto::mapToModel).collect(Collectors.toList()));
		return map(User.class);
	}
}
