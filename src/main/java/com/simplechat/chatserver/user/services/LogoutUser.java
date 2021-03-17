package com.simplechat.chatserver.user.services;

import com.simplechat.chatserver.user.domian.User;
import com.simplechat.chatserver.user.repository.UserRepository;
import com.simplechat.chatserver.user.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogoutUser {
    @Autowired
    public UserRepository userRepository;

    public User execute(UserRequest userRequest) throws Exception{

        Optional<User> userOptional = userRepository.findByUserName(userRequest.getUserName());
        if(!userOptional.isPresent()){
            throw new Exception("User doesn't exist");
        }
        User user = userOptional.get();
        user.setIsOnline(false);
        userRepository.save(user);
        return user;
    }
}
