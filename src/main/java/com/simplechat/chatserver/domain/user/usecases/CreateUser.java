package com.simplechat.chatserver.domain.user.usecases;

import com.simplechat.chatserver.domain.user.User;
import com.simplechat.chatserver.domain.user.UserRepository;
import com.simplechat.chatserver.domain.user.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreateUser {

    @Autowired
    public UserRepository userRepository;

    public User execute(UserRequest userRequest) throws Exception{
        validate(userRequest);
        User user = setUser(userRequest);
        return userRepository.save(user);
    }

    private Boolean validate(UserRequest userRequest) throws Exception {
        boolean isValidUserName = isValidRequestParameter(userRequest.getUserName());
        boolean isValidPassword = isValidRequestParameter(userRequest.getPassword());
        //ExceptionResponse exceptionResponse = new ExceptionResponse();
        if (!isValidUserName || !isValidPassword) {
            //exceptionResponse.addNewError(Error.NOT_VALID_REQUEST_PARAMETERS);
            //throw new ValidationException(exceptionResponse);
            return false;
        }
        return true;
    }

    private boolean isValidRequestParameter(String parameter) throws Exception {
        if (parameter == null)
            throw new Exception();
        return StringUtils.hasLength(parameter.trim());
    }

    private User setUser(UserRequest userRequest){
        return User.builder()
                .userName(userRequest.getUserName())
                .password(userRequest.getPassword())
                .isOnline(true)
                .build();
    }
}
