package com.michael.farm2door.repository;

import com.michael.farm2door.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepo extends MongoRepository<User,String> {
}
