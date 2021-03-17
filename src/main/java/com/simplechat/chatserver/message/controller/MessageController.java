package com.simplechat.chatserver.message.controller;

import com.simplechat.chatserver.message.dto.MessageDTO;
import com.simplechat.chatserver.message.dto.MessageRequest;
import com.simplechat.chatserver.utilities.ResponseUtil;
import com.simplechat.chatserver.message.services.GetAllMessages;
import com.simplechat.chatserver.message.services.SubmitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class MessageController {

    @Autowired
    SubmitMessage submitMessage;

    @Autowired
    GetAllMessages getAllMessages;

    @PostMapping("/messages")
    public void submit(@RequestBody MessageRequest request) throws Exception {
        submitMessage.execute(request);
    }

    @GetMapping("/messages")
    public ResponseEntity get() {
        return ResponseUtil.ok(getAllMessages.execute().stream().map(message -> new MessageDTO(message)).collect(Collectors.toList()));
    }
}
