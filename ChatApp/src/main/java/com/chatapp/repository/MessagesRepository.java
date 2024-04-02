package com.chatapp.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatapp.entity.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {

    void deleteByTimestampBefore(LocalDateTime cutoffTime);

}
