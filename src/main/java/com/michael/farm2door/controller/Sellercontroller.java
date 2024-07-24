package com.michael.farm2door.controller;

import com.michael.farm2door.model.DTOs.LoginDTO;
import com.michael.farm2door.model.manufacturer.Seller;
import com.michael.farm2door.model.user.User;
import com.michael.farm2door.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/seller")
@RestController
public class Sellercontroller {

    @Autowired
    SellerService sellerService;

    @PostMapping("/login")
    protected ResponseEntity<Seller> login(@RequestBody LoginDTO loginDTO){
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        return new ResponseEntity<>(sellerService.loginSeller(email,password), HttpStatus.OK);
    }

    @PostMapping("/register")
    protected ResponseEntity<Seller> registerSeller(@RequestBody Seller seller){
        return new ResponseEntity<>(sellerService.registerSeller(seller),HttpStatus.OK);
    }

    @GetMapping("/user/{sellerId}")
    protected ResponseEntity<Seller> getUser(@PathVariable String sellerId){
        return new ResponseEntity<>(sellerService.singleSeller(sellerId),HttpStatus.OK);
    }
}
