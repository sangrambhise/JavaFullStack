package com.wipro.userservice.service.impl;

import com.wipro.userservice.client.NotificationClient;
import com.wipro.userservice.dto.UserNotificationDTO;
import com.wipro.userservice.entity.User;
import com.wipro.userservice.repo.UserRepository;
import com.wipro.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationClient notificationClient;

    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        notificationClient.notify(new UserNotificationDTO(savedUser, "Created"));
        return savedUser;
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setAddress(updatedUser.getAddress());

        User saved = userRepository.save(user);
        notificationClient.notify(new UserNotificationDTO(saved, "Updated"));
        return saved;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        notificationClient.notify(new UserNotificationDTO(user, "Deleted"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
