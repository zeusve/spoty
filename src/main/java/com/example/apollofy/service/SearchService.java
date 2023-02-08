package com.example.apollofy.service;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.Playlist;
import com.example.apollofy.domain.Track;
import com.example.apollofy.repository.GenreRepository;
import com.example.apollofy.repository.PlaylistRepository;
import com.example.apollofy.repository.TrackRepository;
import com.example.apollofy.repository.UserRepository;
import com.example.apollofy.service.dto.SearchDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private TrackRepository trackRepository;
    private UserRepository userRepository;
    private PlaylistRepository playlistRepository;

    public SearchDTO search(String search) {
        return new SearchDTO(trackRepository.findBySearch(search),
                userRepository.findBySearch(search),
                playlistRepository.findBySearch(search));
    }


}
