package com.rottenbeetle.transform.service;

import com.rottenbeetle.transform.model.User;
import com.rottenbeetle.transform.repo.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return user;
    }


    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null){
            return false;
        }
        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);

        return true;
    }


    @Override
    public List<User> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo,pageSize);
        Page<User> pageResult = userRepository.findAll(paging);
        return pageResult.toList();
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}