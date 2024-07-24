package com.michael.farm2door.repository;

import com.michael.farm2door.model.manufacturer.Seller;
import com.michael.farm2door.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepo extends MongoRepository<Seller,String> {
    Optional<Seller> findByEmail(String email);
}
