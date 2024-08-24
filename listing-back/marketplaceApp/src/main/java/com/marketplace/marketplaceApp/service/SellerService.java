package com.marketplace.marketplaceApp.service;

import com.marketplace.marketplaceApp.entity.Seller;
import com.marketplace.marketplaceApp.entity.User;
import com.marketplace.marketplaceApp.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller getSeller(User user) {
        return sellerRepository.findByUser(user);
    }
}
