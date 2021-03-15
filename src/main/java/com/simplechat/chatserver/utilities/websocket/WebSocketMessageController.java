package com.simplechat.chatserver.utilities.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketMessageController {

    @MessageMapping("/messages")
    @SendTo("/web/messages")
    public String broadcastNews(@Payload String message) {
        return message;
    }
}
