package com.example.apollofy.repository;

import com.example.apollofy.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query(value = "SELECT * FROM event WHERE sport=:sport;", nativeQuery=true)
    Optional<Playlist> findPlaylistByNameIgnoreCase(String name);

    List<Playlist> findByNameContaining(String search);

    List<Playlist> findBySearch(String search);
}
