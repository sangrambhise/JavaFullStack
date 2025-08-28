package com.wipro.usermgmtv2.controller;

import java.util.List;

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

import com.wipro.usermgmtv2.dto.Token;
import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.repo.UserRepo;
import com.wipro.usermgmtv2.service.UserService;

@RestController
@RequestMapping("/user")
 
public class UserController {
	@Autowired
	UserService userServie;
	@Autowired
	UserRepo userRepo;
	
	@GetMapping
	List<User> findAll()
	{
		System.out.println("user-findAll--");
		return userServie.findAll();
	}
	@GetMapping("/{id}")
	User findById(@PathVariable int id)
	{
		return userServie.findById(id);
	}
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		 userServie.deleteById(id);
	}
	
	@PostMapping
	void save(@RequestBody User user)
	{
		userServie.save(user);
		
	}
	
	
	@PutMapping
	void update(@RequestBody User user)
	{
		userServie.save(user);
		
	}
	
//	@PostMapping("/login")
//	Token login(@RequestBody User user)
//	{
//		return userServie.login(user);
//		 
//	}
//	
//	@PostMapping("/register")
//	public void register(@RequestBody User user) {
//	    if (user.getSalt() == null) {
//	        String salt = BCrypt.gensalt();
//	        user.setSalt(salt);
//	    }
//	    user.setPassWord(EncryptUtil.getEncryptedPassword(user.getPassWord(), user.getSalt())); // Encrypt the password
//	    userServie.save(user);
//	}
	
	  @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody User user) {
		  if (userRepo.findByEmail(user.getEmail()) != null) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already registered");
		    }
		    userServie.registerUser(user);
		    return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successful");
		}

	  @PostMapping("/login")
	  public ResponseEntity<Token> login(@RequestBody User user) {
	      Token token = userServie.loginUser(user);
	      if (token != null) {
	          return ResponseEntity.ok(token);
	      }
	      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	  }
}
