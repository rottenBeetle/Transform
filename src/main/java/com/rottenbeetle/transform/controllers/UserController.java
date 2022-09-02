package com.rottenbeetle.transform.controllers;

import com.rottenbeetle.transform.model.User;
import com.rottenbeetle.transform.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> mainPage(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
