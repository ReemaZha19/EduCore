package com.java.EduCore.service;

import com.java.EduCore.dao.UserRepository;
import com.java.EduCore.entity.Role;
import com.java.EduCore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    public void addUser(User user){
        userRepository.save(user);
    }
}

