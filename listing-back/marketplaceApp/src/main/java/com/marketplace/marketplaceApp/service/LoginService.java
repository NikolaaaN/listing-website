package com.marketplace.marketplaceApp.service;

import com.marketplace.marketplaceApp.entity.User;
import com.marketplace.marketplaceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User login(User user){
        User fetchedUser = userRepository.findByEmail(user.getEmail());
        if(fetchedUser == null){
           throw new RuntimeException("User cannot be found");
        }else if(!fetchedUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Wrong password provided");
        }
        return fetchedUser;
    }

}
