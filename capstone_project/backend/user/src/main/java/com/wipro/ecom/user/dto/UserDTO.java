package com.wipro.ecom.user.dto;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {
	@Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String emailId;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password; 
    
    @Column(nullable = true)
    private String address;
}