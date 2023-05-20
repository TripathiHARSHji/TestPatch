package com.patch.controller;

import com.patch.entity.User;
import com.patch.service.UserService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUserDetails(@PathVariable Long id,
                                                    @RequestParam(required = false) String username,
                                                    @RequestParam(required = false) String email) {
    	
        userService.updateUserDetails(id, username, email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
