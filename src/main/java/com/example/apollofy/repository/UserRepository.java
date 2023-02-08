package com.example.apollofy.repository;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("""
        select  user from User user 
        where upper(user.firstName) like upper(concat('%', :q, '%')) or
        upper(user.lastName) like upper(concat('%', :q, '%')) """)
    List<User> findByUserContaining(@Param("q") String q);
}
