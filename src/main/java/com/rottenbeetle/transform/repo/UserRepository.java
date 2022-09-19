package com.rottenbeetle.transform.repo;

import com.rottenbeetle.transform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByActivationCode(String code);
}
