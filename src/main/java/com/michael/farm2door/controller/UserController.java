package com.michael.farm2door.controller;


import com.michael.farm2door.model.DTOs.FullnameDTO;
import com.michael.farm2door.model.DTOs.LoginDTO;
import com.michael.farm2door.model.manufacturer.Seller;
import com.michael.farm2door.model.user.User;
import com.michael.farm2door.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    protected ResponseEntity<User> loginUser(@RequestBody LoginDTO loginDTO){
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        return new ResponseEntity<>(userService.loginUser(email,password), HttpStatus.OK);
    }

    @PostMapping("/register")
    protected ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(userService.registerUser(user),HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    protected ResponseEntity<User> getUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.singleUser(userId),HttpStatus.OK);
    }

    @PutMapping("/user/updateName/{userId}")
    protected ResponseEntity<User> updateuserName(@PathVariable String userId, @RequestBody FullnameDTO fullnameDTO){
        String name = fullnameDTO.getName();
        return new ResponseEntity<>(userService.updateName(userId,name),HttpStatus.OK);
    }

}
