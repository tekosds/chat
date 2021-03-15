package com.simplechat.chatserver.api.domain.user;

import com.simplechat.chatserver.domain.user.User;
import com.simplechat.chatserver.domain.user.UserRepository;
import com.simplechat.chatserver.domain.user.UserRequest;
import com.simplechat.chatserver.domain.user.usecases.CreateUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
        userRequest.setUserName("steca");
        userRequest.setPassword("password");
        userRequest.setIsOnline(true);

        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(UserFixture.getUser());
        User savedUser = createUser.execute(userRequest);

        assertEquals("steca", savedUser.getUserName());
        assertEquals("password", savedUser.getPassword());
        assertEquals(true, savedUser.getIsOnline());
    }

    @Test
    public void createUserTestNullParametar() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName(null);
        userRequest.setPassword("password");
        userRequest.setIsOnline(true);
        assertThrows(Exception.class, () -> {
            createUser.execute(userRequest);
        });
    }
}
