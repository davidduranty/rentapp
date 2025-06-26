package com.duranty.rentapp.service.impl;

import com.duranty.rentapp.model.User;
import com.duranty.rentapp.repository.UserRepository;
import com.duranty.rentapp.service.contract.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
