package io.riteshkm16.lld.cab.service.impl;

import io.riteshkm16.lld.cab.model.User;
import io.riteshkm16.lld.cab.repository.UserRepository;
import io.riteshkm16.lld.cab.service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
