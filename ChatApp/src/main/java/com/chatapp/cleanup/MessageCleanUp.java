package com.chatapp.cleanup;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.chatapp.repository.MessagesRepository;

public class MessageCleanUp {

	@Autowired
    private MessagesRepository messagesRepository; 

    @Scheduled(fixedRate = 3600000) 
    public void deleteOldMessages() {
        LocalDateTime cutoffTime = LocalDateTime.now().minusHours(10);
        messagesRepository.deleteByTimestampBefore(cutoffTime);
    }
}
