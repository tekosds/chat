package com.simplechat.chatserver.user.services;

import com.simplechat.chatserver.user.domian.User;
import com.simplechat.chatserver.user.repository.UserRepository;
import com.simplechat.chatserver.user.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class CreateUser {

    @Autowired
    public UserRepository userRepository;

    public User execute(UserRequest userRequest) throws Exception{
        validate(userRequest);
        checkIfExistUserWithSameUserName(userRequest.getUserName());
        User user = setUser(userRequest);
        return userRepository.save(user);
    }

    private void checkIfExistUserWithSameUserName(String userName) throws Exception {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if(userOptional.isPresent()){
            throw new Exception("User already exist");
        }
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
