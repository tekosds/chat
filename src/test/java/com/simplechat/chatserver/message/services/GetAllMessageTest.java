package com.simplechat.chatserver.message.services;

import com.simplechat.chatserver.message.domain.Message;
import com.simplechat.chatserver.message.dto.MessageRequest;
import com.simplechat.chatserver.message.repository.MessageRepository;
import com.simplechat.chatserver.user.UserFixture;
import com.simplechat.chatserver.user.domian.User;
import com.simplechat.chatserver.user.dto.UserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GetAllMessageTest {

    @InjectMocks
    private GetAllMessages getAllMessages;

    @Mock
    private MessageRepository messageRepository;


    @Test
    public void getAllMessagesTest() throws Exception {
        Message message1 = new Message();
        message1.setUser(UserFixture.getUser());
        message1.setMessageText("Test message");

        Message message2 = new Message();
        message2.setUser(UserFixture.getUser());
        message2.setMessageText("Test message");

        List<Message> allMessages = Arrays.asList(message1, message2);

        Mockito.when(messageRepository.findAll()).thenReturn(allMessages);
        List<Message> allMessagesResult = getAllMessages.execute();

        assertEquals(2, allMessagesResult.size());
    }
}
