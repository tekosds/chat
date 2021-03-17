package com.simplechat.chatserver.message.repository;

import com.simplechat.chatserver.message.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
