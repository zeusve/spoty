package com.example.apollofy.repository;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.Track;
import com.example.apollofy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track,Long> {
    Optional<Track> findTracksByNameIgnoreCase(String name);

    @Query("select track from Track track where ?1 member of track.genres")
    List<Track> findByGenre (Genre genre);

    @Query("""
        select  track from Track track 
        where upper(track.name) like upper(concat('%', :q, '%')) or
        upper(track.description) like upper(concat('%', :q, '%')) """)
    List<Track> findByTrackContaining(@Param("q") String q);

}
