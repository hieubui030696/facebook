package com.example.identityservice.repositories;

import com.example.identityservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);

    @Query(nativeQuery = true, value = "select * from users where id in (:listUserId)")
    List<User> getListUser(@Param("listUserId") List<Long> listUserId);
}
