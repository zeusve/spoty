package com.example.apollofy.repository;

import com.example.apollofy.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Optional<Playlist> findPlaylistByNameIgnoreCase(String name);

}
