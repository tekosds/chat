package com.simplechat.chatserver.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document
@Data
public class Message {

    @Id
    private String id;
    private String messageText;
    @Indexed(direction = IndexDirection.ASCENDING, unique = false)
    private Timestamp sendAt;
    @DBRef
    private User user;

}
