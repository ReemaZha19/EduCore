package com.java.EduCore.controller;

import com.java.EduCore.entity.AuthRequest;
import com.java.EduCore.entity.AuthResponse;
import com.java.EduCore.entity.User;
import com.java.EduCore.service.AuthService;
import com.java.EduCore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        authService.register(user);
        return "User registered successfully";
    }
}
