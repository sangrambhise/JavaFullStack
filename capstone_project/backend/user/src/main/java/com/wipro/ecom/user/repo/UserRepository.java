package com.wipro.ecom.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}