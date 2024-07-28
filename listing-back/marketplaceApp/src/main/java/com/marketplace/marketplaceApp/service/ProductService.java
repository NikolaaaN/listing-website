package com.marketplace.marketplaceApp.service;

import com.marketplace.marketplaceApp.entity.Product;
import com.marketplace.marketplaceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public static final int PRODUCT_PAGE_SIZE = 25;

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Page<Product> getProducts(int page) {
        Pageable pageable = PageRequest.of(page, PRODUCT_PAGE_SIZE);
        return productRepository.findAll(pageable);
    }
}
