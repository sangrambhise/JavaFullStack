package com.wipro.usermgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.usermgmt.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
//	User findByEmailAndPassword(String email,String password);
	User findByEmail(String userName);
}
