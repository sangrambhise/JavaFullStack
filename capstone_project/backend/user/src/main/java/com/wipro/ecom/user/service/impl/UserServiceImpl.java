package com.wipro.ecom.user.service.impl;

import com.wipro.ecom.user.dto.UserDTO;
import com.wipro.ecom.user.entity.User;
import com.wipro.ecom.user.repo.UserRepository;
import com.wipro.ecom.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String CB_NAME = "defaultCB";

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "registerFallback")
    public User register(UserDTO dto) {
        if (userRepository.findByUserId(dto.getUserId()).isPresent()) {
            throw new RuntimeException("UserId already taken");
        }

        User user = new User();
        user.setUserId(dto.getUserId());
        user.setEmailId(dto.getEmailId()); 
        user.setAddress(dto.getAddress());
        user.setPassWord(passwordEncoder.encode(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUserType(1); 

        return userRepository.save(user);
    }

    public User registerFallback(UserDTO dto, Throwable ex) {
        return null; 
    }
    
    @Override
    public User updateUser(Long id, User user) {
    	User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setUserId(user.getUserId());
        existingUser.setEmailId(user.getEmailId());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAddress(user.getAddress());
        if (user.getPassWord() != null && !user.getPassWord().isEmpty()) {
            existingUser.setPassWord(passwordEncoder.encode(user.getPassWord()));
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(existingUser);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "findUserFallback")
    public User findByUsername(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with userid: " + userId));
    }
    
    public User findUserFallback(String userId, Throwable ex) {
        return null; 
    }
}
