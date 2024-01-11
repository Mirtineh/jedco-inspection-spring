package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.models.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(User userDetails);

    String generateRefreshToken(User userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

    long expirationTime(String token);

    boolean isTokenExpired(long expirationTime);

}
