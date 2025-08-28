package com.wipro.usermgmtv2.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.wipro.usermgmtv2.config.JwtConfig;
import com.wipro.usermgmtv2.dto.Token;
import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.repo.UserRepo;
import com.wipro.usermgmtv2.service.UserService;
import com.wipro.usermgmtv2.util.EncryptUtil;
import com.wipro.usermgmtv2.util.JwtUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class USerServiceImpl implements UserService {
	// private static final String SECRET = "d3No4uat7HEgU6RHjJ902G+gTj3+qHNZZ/CN6BUeCa4cKFSkp1AGFXH7ODj3A+fPDf1WQB2x6Yknr6VFh5ySyw==";


	@Autowired
	UserRepo userRepo;
	
	 @Autowired
	    private JwtConfig jwtConfig;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Optional<User> userOpt= userRepo.findById(id);
		if(userOpt.isPresent())
		{
			return userOpt.get();
		}
		return null;
	}

//	@Override
//	public void save(User user) {
//	    if (user.getSalt() == null) {
//	        String salt = BCrypt.gensalt();
//	        user.setSalt(salt);
//	    }
//	    user.setPassWord(EncryptUtil.getEncryptedPassword(user.getPassWord(), user.getSalt()));
//	    userRepo.save(user);
//	}

	@Override
	 public void registerUser(User user) {
	        String salt = BCrypt.gensalt();
	        String hashedPassword = BCrypt.hashpw(user.getPassWord(), salt);
	        user.setSalt(salt);
	        user.setPassWord(hashedPassword);
//	        user.setPassWord(EncryptUtil.getEncryptedPassword(user.getPassWord(), user.getSalt()));
	        userRepo.save(user);
	    }

	@Override
    public boolean isEmailTaken(String email) {
        return userRepo.findByEmail(email) != null;
    }
	
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

//	@Override
//	public Token login(User user) {
//		// TODO Auto-generated method stub
//		User userSalt = userRepo.findByEmail(user.getEmail());
//	    if (userSalt != null) {
//	        String encryptedPassword = EncryptUtil.getEncryptedPassword(user.getPassWord(), userSalt.getSalt());
//	        User validUser = userRepo.findByEmailAndPassWord(user.getEmail(), encryptedPassword);
//
//	        if (validUser != null) {
//	            String jwtToken = "Bearer " + getJWTToken(validUser.getEmail());
//	            Token token = new Token();
//	            token.setToken(jwtToken);
//	            return token;
//	        }
//	    }
//	    return null;
//	}
	
	@Override
	public Token loginUser(User user) {
	    User storedUser = userRepo.findByEmail(user.getEmail());
	    if (storedUser != null && BCrypt.checkpw(user.getPassWord(), storedUser.getPassWord())) {
	        String token = JwtUtil.generateToken(storedUser);
	        System.out.println("Generated JWT Token: " + token);
	        return new Token(token);
	    }
	    return null;
	}

	private String getJWTToken(String username) {
	    Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtConfig.getJwtSecret()));
	    List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

	    return Jwts.builder()
	            .setId("jwtExample")
	            .setSubject(username)
	            .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + 600000)) // 10 minutes expiration
	            .signWith(key)
	            .compact();
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

}
