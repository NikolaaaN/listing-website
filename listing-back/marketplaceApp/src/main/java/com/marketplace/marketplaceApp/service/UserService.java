package com.marketplace.marketplaceApp.service;

import com.marketplace.marketplaceApp.entity.User;
import com.marketplace.marketplaceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    public User getUser(String email) {
       return userRepository.findByEmail(email);
    }
}
