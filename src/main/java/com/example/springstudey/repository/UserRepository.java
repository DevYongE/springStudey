package com.example.springstudey.repository;

import com.example.springstudey.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccout(String accout);

    Optional<User> findByEmail(String email);

    Optional<User> findByAccoutEmail(String accout, String email);
}
