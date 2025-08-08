package com.wipro.userservice.dto;
import com.wipro.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotificationDTO {
    private User user;
    private String action;
}

