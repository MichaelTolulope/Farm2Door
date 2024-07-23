package com.michael.farm2door.model.user;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private String fullName;
    private String email;
    private String password;
    private UserRole role;
}
