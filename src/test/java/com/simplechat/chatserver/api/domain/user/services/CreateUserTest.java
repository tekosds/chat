package com.simplechat.chatserver.api.domain.user.services;

import com.simplechat.chatserver.api.domain.user.UserFixture;
import com.simplechat.chatserver.user.User;
import com.simplechat.chatserver.user.UserRepository;
import com.simplechat.chatserver.user.UserRequest;
import com.simplechat.chatserver.user.services.CreateUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CreateUserTest {

    @InjectMocks
    private CreateUser createUser;

    @Mock
    private UserRepository userRepository;

    @Test
    public void createUserTestSuccessfully() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("steca123");
        userRequest.setPassword("password");

        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(UserFixture.getUser());
        User savedUser = createUser.execute(userRequest);

        assertEquals("steca123", savedUser.getUserName());
        assertEquals("password", savedUser.getPassword());
    }

    @Test
    public void createUserTestNullParametar() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName(null);
        userRequest.setPassword("password");
        assertThrows(Exception.class, () -> {
            createUser.execute(userRequest);
        });
    }
}
