package com.simplechat.chatserver.api.domain.user.services;

import com.simplechat.chatserver.api.domain.user.UserFixture;
import com.simplechat.chatserver.user.User;
import com.simplechat.chatserver.user.UserRepository;
import com.simplechat.chatserver.user.UserRequest;
import com.simplechat.chatserver.user.services.LoginUser;
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
public class LoginUserTest {

    @InjectMocks
    private LoginUser loginUser;

    @Mock
    private UserRepository userRepository;

    @Test
    public void loginUserTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("steca123");
        userRequest.setPassword("password");

        Mockito.when(userRepository.findByUserNameAndPassword(ArgumentMatchers.any(String.class), ArgumentMatchers.any(String.class))).thenReturn(UserFixture.getOptionalUser());
        User loggedInUser = loginUser.execute(userRequest);

        assertEquals(userRequest.getUserName(), loggedInUser.getUserName());
        assertEquals(userRequest.getPassword(), loggedInUser.getPassword());
        assertEquals(true, loggedInUser.getIsOnline());
    }

    @Test
    public void loginUserWrongParametarTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName(null);
        userRequest.setPassword("password");
        assertThrows(Exception.class, () -> {
            loginUser.execute(userRequest);
        });
    }
}
