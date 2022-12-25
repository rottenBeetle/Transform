package com.rottenbeetle.transform.controllers;

import com.rottenbeetle.transform.model.User;
import com.rottenbeetle.transform.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return userService.findAllUsers();
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
