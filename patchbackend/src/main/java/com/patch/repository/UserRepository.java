package com.patch.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.patch.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "UPDATE user SET username = ?2, email = ?3 WHERE id = ?1", nativeQuery = true)
    void updateUserDetails(Long id, String username, String email);
}
