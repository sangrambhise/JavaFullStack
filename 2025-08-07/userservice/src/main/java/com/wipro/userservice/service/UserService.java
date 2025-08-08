package com.wipro.userservice.service;

import com.wipro.userservice.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
    List<User> getAllUsers();
    User getUser(Long id);
}












//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import com.wipro.userservice.client.NotificationClient;
//import com.wipro.userservice.dto.UserNotificationDTO;
//import com.wipro.userservice.entity.User;
//import com.wipro.userservice.repo.UserRepository;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private NotificationClient notificationClient;
//
//    public User createUser(User user) {
//        User savedUser = userRepository.save(user);
//        notificationClient.notify(new UserNotificationDTO(savedUser, "Created"));
//        return savedUser;
//    }
//
//    public User updateUser(Long id, User updatedUser) {
//        User user = userRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setUsername(updatedUser.getUsername());
//        user.setPassword(updatedUser.getPassword());
//        user.setAddress(updatedUser.getAddress());
//
//        User saved = userRepository.save(user);
//        notificationClient.notify(new UserNotificationDTO(saved, "Updated"));
//        return saved;
//    }
//
//    public void deleteUser(Long id) {
//        User user = userRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("User not found"));
//        userRepository.delete(user);
//        notificationClient.notify(new UserNotificationDTO(user, "Deleted"));
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUser(Long id) {
//        return userRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("User not found"));
//    }
//}
