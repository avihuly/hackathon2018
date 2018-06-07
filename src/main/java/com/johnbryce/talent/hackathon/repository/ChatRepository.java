package com.johnbryce.talent.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.talent.hackathon.models.Chat;
import com.johnbryce.talent.hackathon.models.User;

public interface ChatRepository extends JpaRepository<Chat, Long> {

// 	List<Chat> findAllInParticipants(User user);

}
