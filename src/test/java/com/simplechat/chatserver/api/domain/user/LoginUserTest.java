package com.simplechat.chatserver.api.domain.user;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginUserTest {

  /*  @InjectMocks
    private LoginUser loginUser;

    @Mock
    private UserRepository userRepository;

    @Test
    public void loginUserTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("steca");
        userRequest.setPassword("password");

        Mockito.when(userRepository.findByUserNameAndPassword(ArgumentMatchers.any(String.class), ArgumentMatchers.any(String.class))).thenReturn(UserFixture.getOptionalUser());
        User savedUser = loginUser.execute(userRequest);

        assertEquals("steca", savedUser.getUserName());
        assertEquals("password", savedUser.getPassword());
        assertEquals(true, savedUser.getIsOnline());
    }

    @Test
    public void createUserTestNullParametar() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName(null);
        userRequest.setPassword("password");
        assertThrows(Exception.class, () -> {
            loginUser.execute(userRequest);
        });
    }
    */
}
