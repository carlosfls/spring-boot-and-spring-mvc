package org.carlosacademic.springbootandspringmvc.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

/**
 * Is session scoped because we want to generate a new token for every session
 * If the user session expires, the token will be null and the user will have to login again
 */
@Component
@SessionScope
public class TokenProcessor {

    private String token;

    public String generateToken(){
        this.token = UUID.randomUUID().toString();
        return this.token;
    }

    public String getToken(){
        return this.token;
    }
}
