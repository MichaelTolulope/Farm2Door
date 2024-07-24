package com.michael.farm2door.service;

import com.michael.farm2door.model.user.User;
import com.michael.farm2door.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    public User singleUser(String userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public User updateName(String userId, String name) {
        User user = singleUser(userId);
        user.setFullName(name);
        return userRepo.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepo.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user with email not found!"));
        String encodedPassword = user.getPassword();
        if (passwordEncoder.matches(password, encodedPassword)) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid credentials");
        }
    }


}
