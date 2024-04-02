package com.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.config.ChatMessageHandler;
import com.chatapp.dto.MessagesDTO;
import com.chatapp.serviceImpl.MessagesServiceImpl;

@RestController
public class MessagesController {

	@Autowired
	MessagesServiceImpl messagesServiceImpl;
	
    @Autowired
    ChatMessageHandler configuration;
	
	@PostMapping("/topic/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessagesDTO messagesDTO) {
        messagesServiceImpl.processAndSendMessage(messagesDTO.getMessageContent(), messagesDTO.getGroupId(), 
        		messagesDTO.getUserId(), messagesDTO.getTimestamp());
        configuration.broadcast(messagesDTO.getMessageContent());
        return ResponseEntity.ok().build();
    }
	
}

/*	

@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public Messages sendMessage(@Payload Messages messages) {
		System.out.println("Received a message: " + messages);
		return messagesServiceImpl.sendMessage(messages);  
	}

*/