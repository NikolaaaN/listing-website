package com.marketplace.marketplaceApp.controller;

import com.marketplace.marketplaceApp.entity.Product;
import com.marketplace.marketplaceApp.entity.User;
import com.marketplace.marketplaceApp.service.LoginService;
import com.marketplace.marketplaceApp.service.ProductService;
import com.marketplace.marketplaceApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<User> loginUser(@Validated @RequestBody User user) {

        try {
            User fetchedUser = loginService.login(user);
            System.out.println(fetchedUser);
            return new ResponseEntity<>(fetchedUser, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

    }

}
