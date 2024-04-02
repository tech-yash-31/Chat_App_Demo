package com.chatapp.service;

import java.time.LocalDateTime;

public interface MessagesService {

	public void processAndSendMessage(String messageContent, Integer groupId, int userId, LocalDateTime timestamp);
	public boolean validateMessage(String messageContent);
}
