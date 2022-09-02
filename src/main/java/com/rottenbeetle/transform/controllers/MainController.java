package com.rottenbeetle.transform.controllers;

import com.rottenbeetle.transform.model.User;
import com.rottenbeetle.transform.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> mainPage(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
