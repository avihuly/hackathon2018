package com.johnbryce.talent.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.johnbryce.talent.hackathon.dto.UserDto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="users")
public class User extends AbstractModel {

	private static final long serialVersionUID = -8988936449622467004L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	private String nickName;
	
	@Override
	public UserDto mapToDto() {
		return map(UserDto.class);
	}
	
}
