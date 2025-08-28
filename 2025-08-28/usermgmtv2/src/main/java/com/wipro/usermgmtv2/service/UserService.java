package com.wipro.usermgmtv2.service;

import java.util.List;

import com.wipro.usermgmtv2.dto.Token;
import com.wipro.usermgmtv2.entity.User;

public interface UserService {

	List<User> findAll();
	User findById(int id);
	void save(User user);
	void deleteById(int id);
	Token login(User user);
	
}
