package org.example.myfinanceapi.api.controller;

import org.example.myfinanceapi.model.entity.UserEntity;
import org.example.myfinanceapi.model.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/listUsers")
    public ResponseEntity<List<UserEntity>> listUsers() {
        return ResponseEntity.ok(repository.findAll());
    }
    @PostMapping("/createUser")
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(repository.save(user));
    }
}