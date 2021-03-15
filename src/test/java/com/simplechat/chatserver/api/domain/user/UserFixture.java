package com.simplechat.chatserver.api.domain.user;

import com.simplechat.chatserver.user.User;

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
