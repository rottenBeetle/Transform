package com.rottenbeetle.transform.service;

import com.rottenbeetle.transform.model.User;

import java.util.List;

public interface UserService {
    List<User> findPaginated(int pageNo, int pageSize);
    List<User> findAllUsers();
}
