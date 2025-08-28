package com.wipro.usermgmtv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.usermgmtv2.dto.Token;
import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.service.UserService;

@RestController
@RequestMapping("/user")
 
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	List<User> findAll()
	{
		return userService.findAll();
	}
	@GetMapping("/{id}")
	User findById(@PathVariable int id)
	{
		return userService.findById(id);
	}
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		 userService.deleteById(id);
	}
	@PostMapping
	void save(@RequestBody User user)
	{
		userService.save(user);
		
	}
	
	@PutMapping
	void update(@RequestBody User user)
	{
		userService.save(user);
		
	}
	
	@PostMapping("/login")
	Token login(@RequestBody User user)
	{
		return userService.login(user);
		 
	}

}
