package com.ijse.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.dto.UserDTO;
import com.ijse.pos.entity.User;
import com.ijse.pos.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User changeUserPassword(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setPassword(userDTO.getPassword());
            return userRepository.save(user);
        }else{
            return null;
        }   
}
}