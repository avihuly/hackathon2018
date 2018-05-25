package com.johnbryce.talent.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	
	@Override
	public UserDto mapToDto() {
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		return dto;
	}
	
}
