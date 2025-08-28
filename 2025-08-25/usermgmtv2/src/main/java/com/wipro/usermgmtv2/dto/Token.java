package com.wipro.usermgmtv2.dto;
import lombok.Data;
@Data
public class Token {
    private String token;
    public Token(String token) {
        this.token = token;
    }
}