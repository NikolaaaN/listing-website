package com.marketplace.marketplaceApp.controller;

import com.marketplace.marketplaceApp.entity.Product;
import com.marketplace.marketplaceApp.entity.Seller;
import com.marketplace.marketplaceApp.service.ProductService;
import com.marketplace.marketplaceApp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Seller> getSellerInfo(Long id){
        try{
            Product product = productService.getProduct(id);
            Seller seller = sellerService.getSeller(product.getUser());
            System.out.println(seller.getName());
            //TODO: sends with email and password be careful
            return ResponseEntity.ok(seller);

        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
