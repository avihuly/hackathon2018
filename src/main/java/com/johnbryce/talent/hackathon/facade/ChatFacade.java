package com.johnbryce.talent.hackathon.facade;

import java.util.List;

import com.johnbryce.talent.hackathon.models.Chat;

public interface ChatFacade {

	public List<Chat> getChats();
	
	public Chat getChat(long id);
	
	public Chat createChat(Chat chat);

}
