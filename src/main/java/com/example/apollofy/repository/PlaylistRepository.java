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
        where upper(playlist.name) like upper(concat('%', :q, '%')) or
        upper(playlist.description) like upper(concat('%', :q, '%')) """)
    List<Playlist> findByPlaylistContaining(@Param("q") String q);
}
