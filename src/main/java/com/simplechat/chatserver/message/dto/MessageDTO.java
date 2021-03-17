package com.simplechat.chatserver.message.dto;

import com.simplechat.chatserver.message.domain.Message;
import com.simplechat.chatserver.user.dto.UserDTO;
import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
    private String messageText;
    private Date sendAt;
    private UserDTO user;

    public MessageDTO(Message message){
        this.messageText = message.getMessageText();
        this.sendAt = message.getSendAt();
        this.user = new UserDTO(message.getUser());
    }
}
