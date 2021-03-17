package com.simplechat.chatserver.message.domain;

import com.simplechat.chatserver.user.domian.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    private String id;
    private String messageText;
    @Indexed(direction = IndexDirection.ASCENDING, unique = false)
    private Date sendAt;
    @DBRef
    private User user;

}
