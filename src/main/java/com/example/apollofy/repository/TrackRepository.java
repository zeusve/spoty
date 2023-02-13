package com.example.apollofy.repository;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.Track;
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
        select track from Track track
        where UPPER(track.name) like UPPER(CONCAT(('%'),(:q),('%'))) or
        UPPER(track.description) like UPPER(CONCAT(('%'),(:q),('%')))
        """)
    List<Track> findByTrackContaining(@Param("q") String q);

}
