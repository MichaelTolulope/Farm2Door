package com.michael.farm2door.service;

import com.michael.farm2door.model.manufacturer.Seller;
import com.michael.farm2door.model.user.User;
import com.michael.farm2door.repository.SellerRepo;
import com.michael.farm2door.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class SellerService {

    @Autowired
    SellerRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    public Seller singleSeller(String userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Seller updateBusinessName(String userId, String name) {
        Seller user = singleSeller(userId);
        user.setBusinessName(name);
        return userRepo.save(user);
    }

    public Seller loginSeller(String email, String password) {
        Seller user = userRepo.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user with email not found!"));
        String encodedPassword = user.getPassword();
        if (passwordEncoder.matches(password, encodedPassword)) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid credentials");
        }
    }

    public Seller registerSeller(Seller seller){

        return userRepo.save(seller);
    }
}
