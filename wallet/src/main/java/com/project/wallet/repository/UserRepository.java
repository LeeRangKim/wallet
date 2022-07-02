package com.project.wallet.repository;

import com.project.wallet.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{
    User save(User user);
    Optional<User> findByUserId(Long user_id);
    Optional<User> findByUserName(String name);
    List<User> findAll();

}
