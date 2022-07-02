package com.project.wallet.service;

import com.project.wallet.domain.User;
import com.project.wallet.repository.JpaUserRepository;
import com.project.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Long join(User user){
        userRepository.save(user);
        return user.getUser_id();
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUser(Long userId){
        return userRepository.findByUserId(userId);
    }

    public Optional<User> findUser(String name){
        return userRepository.findByUserName(name);
    }
}
