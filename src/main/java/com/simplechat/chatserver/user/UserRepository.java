package com.simplechat.chatserver.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserNameAndPassword(String userName, String password);
    Optional<User> findByUserName(String userName);
}
