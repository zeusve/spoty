package com.example.apollofy.repository;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<Genre> findBySearch(String search);
}
