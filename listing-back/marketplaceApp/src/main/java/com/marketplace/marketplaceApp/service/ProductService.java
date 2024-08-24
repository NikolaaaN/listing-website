package com.marketplace.marketplaceApp.service;

import com.marketplace.marketplaceApp.entity.Product;
import com.marketplace.marketplaceApp.entity.User;
import com.marketplace.marketplaceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public static final int PRODUCT_PAGE_SIZE = 30;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;

    public Product addProduct(Product product, String email){
        System.out.println(email);
        User user = userService.getUser(email);
        if(user != null){
            product.setUser(user);
            return productRepository.save(product);
        }else{
            throw new Error("User not found");
        }
    }

    public Page<Product> getProducts(int page) {
        Pageable pageable = PageRequest.of(page, PRODUCT_PAGE_SIZE);
        return productRepository.findAll(pageable);
    }

    public Product getProduct(Long id){
        return productRepository.findProductById(id);
    }
}
