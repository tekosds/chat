package com.simplechat.chatserver.message.services;

import com.simplechat.chatserver.message.Message;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class NotificationServices {

    private final SimpMessagingTemplate simpleMessagingTemplate;
    private static final String WS_MESSAGE_DESTINATION = "/web/messages";

    NotificationServices(SimpMessagingTemplate simpleMessagingTemplate){
        this.simpleMessagingTemplate = simpleMessagingTemplate;
    }

    public void sendMessage(Message message){
        simpleMessagingTemplate.convertAndSend(WS_MESSAGE_DESTINATION, message);
    }
}
