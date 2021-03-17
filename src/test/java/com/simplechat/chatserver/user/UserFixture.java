package com.simplechat.chatserver.user;

import com.simplechat.chatserver.user.domian.User;

import java.util.Optional;

public final class UserFixture {

 public static User getUser(){
     return User.builder()
             .userName("steca123")
             .password("password")
             .build();
 }

 public static Optional<User> getOptionalUser(){
     return Optional.of(getUser());
 }
}
