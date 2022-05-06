package com.msd.qrservice.repositories;

import com.msd.qrservice.domain.User;
import com.msd.qrservice.dto.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndStatus(String username, Status active);

    Optional<User> findByUsernameAndAccessToken(String username, String jwtToken);
}
