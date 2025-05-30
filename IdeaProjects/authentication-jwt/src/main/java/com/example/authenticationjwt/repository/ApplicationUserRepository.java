package com.example.authenticationjwt.repository;

import com.example.authenticationjwt.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    @Query("select u from ApplicationUser u left join fetch u.roles where u.username = :username")
    Optional<ApplicationUser> findApplicationUserByUsername(String username);

    @Query("select u from ApplicationUser u left join fetch u.roles where u.id = :id")
    Optional<ApplicationUser> findApplicationUserById(Integer id);
}