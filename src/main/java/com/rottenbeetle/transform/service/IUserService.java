package com.rottenbeetle.transform.service;

import com.rottenbeetle.transform.model.User;

import java.util.List;

public interface IUserService {
    List<User> findPaginated(int pageNo, int pageSize);
}
