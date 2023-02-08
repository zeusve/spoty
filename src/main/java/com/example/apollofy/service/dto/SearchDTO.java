package com.example.apollofy.service.dto;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.Playlist;
import com.example.apollofy.domain.Track;

import java.util.ArrayList;
import java.util.List;

public class SearchDTO {
    public List<Track> trackList = new ArrayList<>();
    public List<Genre> genreList = new ArrayList<>();
    public List<Playlist> playlistList = new ArrayList<>();

    public SearchDTO (){}

    public SearchDTO(List<Track> trackList, List<Genre> genreList, List<Playlist> playlistList) {
        this.trackList = trackList;
        this.genreList = genreList;
        this.playlistList = playlistList;
    }
}
