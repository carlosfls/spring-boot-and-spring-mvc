package org.carlosacademic.springbootandspringmvc.controller;

import org.carlosacademic.springbootandspringmvc.model.User;
import org.carlosacademic.springbootandspringmvc.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user", new User("", ""));
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        boolean success = authService.login(user.username(), user.password());
        if (success){
            return "redirect:/products";
        }else{
            return "login";
        }
    }
}
