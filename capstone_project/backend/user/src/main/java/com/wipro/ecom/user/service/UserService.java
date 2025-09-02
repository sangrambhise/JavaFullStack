package com.wipro.ecom.user.service;

import com.wipro.ecom.user.dto.UserDTO;
import com.wipro.ecom.user.entity.User;

import java.util.List;

public interface UserService {
    User register(UserDTO userDTO);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
    User findByUsername(String username);
}
