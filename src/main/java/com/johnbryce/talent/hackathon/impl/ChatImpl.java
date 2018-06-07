package com.johnbryce.talent.hackathon.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnbryce.talent.hackathon.facade.ChatFacade;
import com.johnbryce.talent.hackathon.facade.CurrentUserFacade;
import com.johnbryce.talent.hackathon.models.Chat;
import com.johnbryce.talent.hackathon.repository.ChatRepository;

public class ChatImpl implements ChatFacade {
	
	@Autowired
	ChatRepository chatRepository;
	
	@Autowired
	CurrentUserFacade  currentUserFacade;
	
	@Override
	public List<Chat> getChats() {
	//	return chatRepository.findAllInParticipants(currentUserFacade.getUser());
		return null;
	}

	@Override
	public Chat getChat(long id) {
		return chatRepository.getOne(id);
	}

	@Override
	public Chat createChat(Chat chat) {
		return chatRepository.save(chat);
	}

}
