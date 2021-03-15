package com.simplechat.chatserver.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private Boolean isOnline;
}
