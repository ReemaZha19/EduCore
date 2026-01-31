package com.java.EduCore.service;

import com.java.EduCore.entity.Role;
import com.java.EduCore.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService() {
        users.put("admin",
                new User("admin", encoder.encode("admin123"), Role.ROLE_ADMIN)
        );
        users.put("user",
                new User("user", encoder.encode("user123"), Role.ROLE_USER)
        );
    }

    public User getByUsername(String username){
        return users.get(username);
    }

    public void addUser(User user){
        users.put(user.getUsername(), user);
    }
}

