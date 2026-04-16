package com.coleman.security.repositories;

import com.coleman.security.models.Role;
import com.coleman.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<Role> findByName(String name);

    Optional<User> findByEmail(String email);
}
