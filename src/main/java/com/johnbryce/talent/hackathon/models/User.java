package com.johnbryce.talent.hackathon.models;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.johnbryce.talent.hackathon.dto.UserDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "users")
public class User extends AbstractModel {

	private static final long serialVersionUID = -8988936449622467004L;

	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String email;
	private String firstName;
	private String lastName;
	private byte[] salt;
	private byte[] password;
	private Long userType;

//	@ManyToMany
	// @ElementCollection
//	private List<Chat> chats;

	@Override
	public UserDto mapToDto() {
		UserDto map = map(UserDto.class);
//		if (chats != null) {
//			map.setChats(chats.stream().map(Chat::mapToDto).collect(Collectors.toList()));
//		}
		return map;
	}

}
