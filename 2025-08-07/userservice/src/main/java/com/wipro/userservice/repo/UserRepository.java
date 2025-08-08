package com.wipro.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
