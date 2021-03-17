package com.simplechat.chatserver.user.dto;

import com.simplechat.chatserver.user.domian.User;
import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private Boolean isOnline;

    public UserDTO(User user){
        this.userName = user.getUserName();
        this.isOnline = user.getIsOnline();
    }
}
