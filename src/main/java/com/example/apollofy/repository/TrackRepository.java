package com.example.apollofy.repository;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track,Long> {
    Optional<Track> findTracksByNameIgnoreCase(String name);

    @Query("select track from Track track where ?1 member of track.genres")
    List<Track> findByGenre (Genre genre);

}
