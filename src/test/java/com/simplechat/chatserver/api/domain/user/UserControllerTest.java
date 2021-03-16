package com.simplechat.chatserver.api.domain.user;

import com.simplechat.chatserver.ChatserverApplication;
import com.simplechat.chatserver.user.UserRequest;
import com.simplechat.chatserver.user.services.CreateUser;
import com.simplechat.chatserver.user.services.LoginUser;
import com.simplechat.chatserver.user.services.LogoutUser;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ChatserverApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CreateUser createUser;

    @Autowired
    LoginUser loginUser;

    @Autowired
    LogoutUser logoutUser;

    @Test
    public void createUserTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("steca123");
        userRequest.setPassword("password");

        Mockito.when(createUser.execute(ArgumentMatchers.any())).thenReturn(UserFixture.getUser());

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
