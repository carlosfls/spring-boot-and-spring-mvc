package org.carlosacademic.springbootandspringmvc.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final TokenProcessor tokenProcessor;

    public AuthService(TokenProcessor tokenProcessor) {
        this.tokenProcessor = tokenProcessor;
    }

    public boolean login(String username, String password){
        System.out.println("Authenticating user: " + username);
        if ("admin".equals(username) && "admin".equals(password)){
            System.out.println("User authenticated successfully");
            System.out.println("Generating token...");
            String token = tokenProcessor.generateToken();
            System.out.println("Token generated: " + token);
            return true;
        }
        return false;
    }
}
