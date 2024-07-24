package com.michael.farm2door.model.manufacturer;

import com.michael.farm2door.model.product.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Seller {
    @Id
    private String id;
    private String businessName;
    private String businessFounder;
    private String email;
    private String profileImageUrl;
    private String backgroundProfileImageUrl;
    private String password;
    private String typeOfProduct;
    private List<Product> productList;
}
