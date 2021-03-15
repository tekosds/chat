package com.simplechat.chatserver.user.services;

import com.simplechat.chatserver.user.User;
import com.simplechat.chatserver.user.UserRepository;
import com.simplechat.chatserver.user.UserRequest;
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
        return userRepository.save(user);
    }
}
