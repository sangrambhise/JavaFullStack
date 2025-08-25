package com.wipro.usermgmtv2.util;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptUtil {
	  public static String getEncryptedPassword(String plainPassword, String salt) {
	        if (salt == null) {
	            salt = BCrypt.gensalt();
	            System.out.println("Generated Salt: " + salt);
	        }
	        
	        String hashedPassword = BCrypt.hashpw(plainPassword, salt);
	        System.out.println("Hashed Password: " + hashedPassword);
	        return hashedPassword;
	    }

	    public static void main(String[] args) {
	        String password = "pass";
	        String salt = BCrypt.gensalt(); // Generate salt separately
	        System.out.println("Encrypted password: " + getEncryptedPassword(password, salt));
	    }

}
