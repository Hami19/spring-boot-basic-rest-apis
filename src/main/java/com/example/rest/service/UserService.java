package com.example.rest.service;

import com.example.rest.entity.User;
import com.example.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ
    public List<User> getUser() {
        return userRepository.findAll();
    }

    // DELETE
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User user) {
        User u = userRepository.findById(userId).get();
        user.setId(u.getId());
        return userRepository.save(user);
    }
}
