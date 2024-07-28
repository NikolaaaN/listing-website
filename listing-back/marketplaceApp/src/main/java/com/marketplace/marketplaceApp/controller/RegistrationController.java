package com.marketplace.marketplaceApp.controller;

import com.marketplace.marketplaceApp.entity.User;
import com.marketplace.marketplaceApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> registerUser(@Validated @RequestBody User user){
        System.out.println(user);
        try{
            User registeredUser = userService.addUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);

        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
