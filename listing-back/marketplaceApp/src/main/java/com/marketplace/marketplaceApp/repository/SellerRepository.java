package com.marketplace.marketplaceApp.repository;

import com.marketplace.marketplaceApp.entity.Seller;
import com.marketplace.marketplaceApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findByUser(User user);

}
