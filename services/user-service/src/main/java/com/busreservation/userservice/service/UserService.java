package com.busreservation.userservice.service;

import com.busreservation.userservice.dto.UserRequest;
import com.busreservation.userservice.dto.UserResponse;
import com.busreservation.userservice.model.User;

import java.util.Optional;

public interface UserService {
    User register(UserRequest userRequest);

    Optional<User> findByUsername(String username);
}
