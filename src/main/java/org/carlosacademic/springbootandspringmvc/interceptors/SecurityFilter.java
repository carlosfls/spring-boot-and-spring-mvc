package org.carlosacademic.springbootandspringmvc.interceptors;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.carlosacademic.springbootandspringmvc.service.TokenProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenProcessor tokenProcessor;

    public SecurityFilter(TokenProcessor tokenProcessor) {
        this.tokenProcessor = tokenProcessor;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!request.getRequestURI().contains("/login")){
            System.out.println("Authenticating request...");
            if (tokenProcessor.getToken() == null){
                response.setStatus(401);
            }
            System.out.println("Request authenticated successfully");
            filterChain.doFilter(request, response);
        }
    }
}
