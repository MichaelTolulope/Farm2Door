package com.michael.farm2door.model.product;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Product {
    private String id;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productCategory;
    private String productQuantity;

}
