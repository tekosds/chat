package com.simplechat.chatserver.user;

import com.simplechat.chatserver.utilities.ResponseUtil;
import com.simplechat.chatserver.user.services.CreateUser;
import com.simplechat.chatserver.user.services.LoginUser;
import com.simplechat.chatserver.user.services.LogoutUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    CreateUser createUser;

    @Autowired
    LoginUser loginUser;

    @Autowired
    LogoutUser logoutUser;

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody UserRequest request) throws Exception {
        return ResponseUtil.ok(createUser.execute(request));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequest request) throws Exception {
        return ResponseUtil.ok(loginUser.execute(request));
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody UserRequest request) throws Exception {
        return ResponseUtil.ok(logoutUser.execute(request));
    }
}
