package com.simplechat.chatserver.message.services;

import com.simplechat.chatserver.message.repository.MessageRepository;
import com.simplechat.chatserver.message.dto.MessageRequest;
import com.simplechat.chatserver.user.domian.User;
import com.simplechat.chatserver.user.repository.UserRepository;
import com.simplechat.chatserver.message.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SubmitMessage {

    @Autowired
    public MessageRepository messageRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired NotificationServices notificationServices;

    public Message execute(MessageRequest request) throws Exception {
        Message message = setMessage(request);
        message = messageRepository.save(message);
        notificationServices.sendMessage(message);
        return message;
    }

    private Message setMessage(MessageRequest request) throws Exception {
        return Message.builder()
                .messageText(request.getMessageText())
                .user(getUser(request.getUserName()))
                .sendAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }

    private User getUser(String userName) throws Exception {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if(!userOptional.isPresent()){
            throw new Exception("User doesn't exist");
        }
        return userOptional.get();
    }
}
