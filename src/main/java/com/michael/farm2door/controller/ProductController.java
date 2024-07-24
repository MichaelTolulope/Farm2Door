package com.michael.farm2door.controller;

import com.michael.farm2door.model.product.Product;
import com.michael.farm2door.service.SellerService;
import com.michael.farm2door.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/create-product/{sellerId}")
    protected ResponseEntity<Product> createproduct(@PathVariable String sellerId, @RequestBody Product product){
        return new ResponseEntity<>(sellerService.createProduct(sellerId,product), HttpStatus.OK);
    }

    @GetMapping("/all-sellerProducts/{sellerId}")
    protected ResponseEntity<List<Product>> getAllSellerProduct(@PathVariable String sellerId){
        return new ResponseEntity<>(sellerService.getAllProductsForSeller(sellerId),HttpStatus.OK);
    }

    @GetMapping("/get-all")
    protected ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(sellerService.getAllProducts(),HttpStatus.OK);
    }
}
