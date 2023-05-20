package com.patch.serviceimpl;

import com.patch.entity.User;
import com.patch.repository.UserRepository;
import com.patch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUserDetails(Long id, String username, String email) {
        userRepository.updateUserDetails(id, username, email);
    }
}
