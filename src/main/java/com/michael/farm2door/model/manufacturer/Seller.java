package com.michael.farm2door.model.manufacturer;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document
public class Seller {
    private String businessName;
    private String businessFounder;
    private String profileImageUrl;
    private String backgroundProfileImageUrl;
    private String password;
    private String typeOfProduct;
}
