package com.wipro.usermgmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.usermgmt.dto.Token;
import com.wipro.usermgmt.entity.User;
import com.wipro.usermgmt.service.UserService;

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
	    public ResponseEntity<Token> login(@RequestBody User user) {
	        Token token = userService.login(user);
	        if (token != null) {
	            return ResponseEntity.ok(token);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    }
	
//	@PostMapping("/register")
//	public ResponseEntity<?> register(@RequestBody User user) {
//	    if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
//	        return ResponseEntity.badRequest().body("Password must not be null or empty");
//	    }
//
//	    String salt = BCrypt.gensalt();
//	    String encryptedPassword = EncryptUtil.getEncryptedPassword(user.getPassword(), salt);	    
//	    user.setPassword(encryptedPassword);
//	    user.setSalt(salt);
//	    userService.save(user);
//	    return ResponseEntity
//	            .ok(Map.of("message", "User registered successfully"));
//	}
	 
	 @PostMapping("/register")
	 public ResponseEntity<?> register(@RequestBody User user) {
	     if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
	         return ResponseEntity.badRequest().body("Password must not be null or empty");
	     }
//	     String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//	     user.setPassword(encryptedPassword);

	     userService.save(user);
	     return ResponseEntity.ok(Map.of("message", "User registered successfully"));
	 }

}
