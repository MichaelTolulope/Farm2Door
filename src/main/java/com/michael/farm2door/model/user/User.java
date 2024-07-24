package com.michael.farm2door.model.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document
public class User {
    @Id
    private String id;
    private String fullName;
    private String profileImageUrl;
    private String email;
    private String password;
    private String address;
}
