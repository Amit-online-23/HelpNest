package com.helpnest.authservice.service;

import com.helpnest.authservice.dto.AuthResponse;
import com.helpnest.authservice.dto.LoginRequest;
import com.helpnest.authservice.model.JwtUser;
import com.helpnest.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.helpnest.authservice.model.JwtUser;


@Service
public class AuthService {

    private final JwtUtil jwtUtil;
    private final RestTemplate restTemplate;

    @Value("${user-service.url}")
    private String userServiceUrl;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<?> login(LoginRequest request) {
        String url = userServiceUrl + "/api/users/validate";

        try {
            // Call user-service to validate credentials
            ResponseEntity<JwtUser> response = restTemplate.postForEntity(url, request, JwtUser.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                JwtUser user = response.getBody();

                // Generate JWT token using user details
                String token = jwtUtil.generateToken(user);

                // Return full response to client
                AuthResponse authResponse = new AuthResponse(
                        user.getUserId(),
                        user.getUsername(),
                        user.getRole(),
                        user.getGroupId(),
                        token
                );

                return ResponseEntity.ok().body(authResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials or user-service error");
        }
    }
}
