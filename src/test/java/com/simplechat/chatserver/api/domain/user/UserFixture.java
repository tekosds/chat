package com.simplechat.chatserver.api.domain.user;

import com.simplechat.chatserver.domain.user.User;

public final class UserFixture {

 public static User getUser(){
     return User.builder()
             .userName("steca")
             .password("password")
             .isOnline(true)
             .build();
 }
}
