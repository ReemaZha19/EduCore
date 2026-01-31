package com.java.EduCore.service;

import com.java.EduCore.config.JwtUtil;
import com.java.EduCore.entity.AuthRequest;
import com.java.EduCore.entity.AuthResponse;
import com.java.EduCore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponse login(AuthRequest request){
        User user = userService.getByUsername(request.getUsername());
        if(user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username/password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());
        return new AuthResponse(token);
    }

    public void register(User user ){
        if(userService.getByUsername(user.getUsername()) !=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }

}
