package com.ijse.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos.dto.UserDTO;
import com.ijse.pos.entity.User;
import com.ijse.pos.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User creatUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/users/{userId}/change-password")
    public ResponseEntity <User> changeUserPassword(@PathVariable Long userId, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(userService.changeUserPassword(userId, userDTO));
    }
    
}
