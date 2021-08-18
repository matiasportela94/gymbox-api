package com.gymbox.repository.user;

import com.gymbox.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByDni(Long dni);

    Boolean existsByEmail(String email);
}
