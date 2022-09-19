package com.rottenbeetle.transform.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rottenbeetle.transform.model.Role;
import com.rottenbeetle.transform.model.User;
import com.rottenbeetle.transform.repo.UserRepository;
import com.rottenbeetle.transform.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;
    private final IUserService userService;

    public UserController(UserRepository userRepository, IUserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> mainPage() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{pageNo}/{pageSize}")
    public List<User> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize) {
 /*       {
            data: [data],
            totalPages: 100,
            passingersPages: 8300
        }*/
        return userService.findPaginated(pageNo, pageSize);
    }
}
