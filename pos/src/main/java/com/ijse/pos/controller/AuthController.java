package com.ijse.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos.dto.LogingDTO;
import com.ijse.pos.entity.User;
import com.ijse.pos.repository.UserRepository;
import com.ijse.pos.security.jwt.JWTTokenProvider;
import com.ijse.pos.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;



    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("User name is already use");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already use");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return ResponseEntity.ok(userService.createUser(newUser));
    }

    @PostMapping("/auth/login")
    public ResponseEntity <?> login(@RequestBody LogingDTO logingDTO){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(logingDTO.getUsername(), logingDTO.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(jwt);
    }
}
