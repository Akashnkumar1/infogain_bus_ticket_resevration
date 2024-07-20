package com.busreservation.userservice.service;


import com.busreservation.userservice.dto.UserRequest;
import com.busreservation.userservice.dto.UserResponse;
import com.busreservation.userservice.model.User;
import com.busreservation.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * @param userRequest
     * @return
     */
    @Override
    public User register(UserRequest userRequest) {
        userRepository.findByUsername(userRequest.getUsername()).ifPresent(user -> {
            throw new IllegalArgumentException("Username already exists");
        });
        User newUser = User.builder()
                .username(userRequest.getUsername()).email(userRequest.getEmail())
                .password(userRequest.getPassword()).build();
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
