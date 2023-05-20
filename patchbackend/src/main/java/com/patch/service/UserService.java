package com.patch.service;

import com.patch.entity.User;

public interface UserService {
    User getUserById(Long id);
    void updateUserDetails(Long id, String username, String email);
}
