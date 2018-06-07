package com.johnbryce.talent.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.talent.hackathon.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User getOneByEmail(String email);
}
