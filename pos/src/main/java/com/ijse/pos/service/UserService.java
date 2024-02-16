package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos.dto.UserDTO;
import com.ijse.pos.entity.User;

@Service
public interface UserService {
     List<User> getAllUsers();
     User createUser(User user);
     User getUserById(Long userId);
     User changeUserPassword(Long userId, UserDTO userDTO);

    

}
