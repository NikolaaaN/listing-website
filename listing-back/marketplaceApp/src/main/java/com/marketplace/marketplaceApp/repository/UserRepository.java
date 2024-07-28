package com.marketplace.marketplaceApp.repository;

import com.marketplace.marketplaceApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
