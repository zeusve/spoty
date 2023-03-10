package com.example.apollofy.repository;

import com.example.apollofy.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Optional<Playlist> findPlaylistByNameIgnoreCase(String name);

    @Query("""
        select  playlist from Playlist playlist
        where UPPER(playlist.name) like UPPER(CONCAT(('%'),(:q),('%'))) or
        UPPER(playlist.description) like UPPER(CONCAT(('%'),(:q),('%')))
        """)
    List<Playlist> findByPlaylistContaining(@Param("q") String q);
}
