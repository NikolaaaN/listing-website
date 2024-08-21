package com.marketplace.marketplaceApp.controller;

import com.marketplace.marketplaceApp.entity.Product;
import com.marketplace.marketplaceApp.service.ProductService;
import com.marketplace.marketplaceApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getProducts(@RequestParam(defaultValue = "0") int page) {
        System.out.println(page);
        Page<Product> products = productService.getProducts(page);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<String> submitProduct(
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("image") MultipartFile image) {

        try {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            InputStream inputStream = image.getInputStream();
            byte[] imageArr = StreamUtils.copyToByteArray(inputStream);
            product.setImage(imageArr);
            productService.addProduct(product, email);
            return ResponseEntity.ok("Product submitted successfully");
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}