package com.simplechat.chatserver.api.user;

import com.simplechat.chatserver.api.utilities.ResponseUtil;
import com.simplechat.chatserver.domain.user.UserRequest;
import com.simplechat.chatserver.domain.user.usecases.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    CreateUser createUser;

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserRequest request) throws Exception {
        return ResponseUtil.ok(createUser.execute(request));
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserRequest request) throws Exception {
        return ResponseUtil.ok(createUser.execute(request));
    }
}
