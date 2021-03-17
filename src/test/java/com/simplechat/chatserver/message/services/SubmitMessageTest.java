package com.simplechat.chatserver.message.services;

import com.simplechat.chatserver.message.domain.Message;
import com.simplechat.chatserver.message.dto.MessageRequest;
import com.simplechat.chatserver.message.repository.MessageRepository;
import com.simplechat.chatserver.user.UserFixture;
import com.simplechat.chatserver.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class SubmitMessageTest {

    @InjectMocks
    private SubmitMessage submitMessage;

    @Mock
    private MessageRepository messageRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    NotificationServices notificationServices;

    @Test
    public void submitMessageTest() throws Exception {
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMessageText("Test message");
        messageRequest.setUserName("steca123");

        Message messageResponse = new Message();
        messageResponse.setUser(UserFixture.getUser());
        messageResponse.setMessageText("Test message");

        Mockito.when(messageRepository.save(ArgumentMatchers.any())).thenReturn(messageResponse);
        Mockito.when(userRepository.findByUserName(ArgumentMatchers.any())).thenReturn(UserFixture.getOptionalUser());
        doNothing().when(notificationServices).sendMessage(ArgumentMatchers.any());
        Message messageResult = submitMessage.execute(messageRequest);

        assertEquals(messageResult.getMessageText(), messageRequest.getMessageText());
        assertEquals(messageResult.getUser().getUserName(), messageRequest.getUserName());
    }
}
