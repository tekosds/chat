package com.simplechat.chatserver.message.services;

import com.simplechat.chatserver.message.domain.Message;
import com.simplechat.chatserver.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllMessages {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> execute() {
        return messageRepository.findAll();
    }
}
