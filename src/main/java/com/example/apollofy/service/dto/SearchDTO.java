package com.example.apollofy.service.dto;

import com.example.apollofy.domain.Playlist;
import com.example.apollofy.domain.Track;
import com.example.apollofy.domain.User;

import java.util.ArrayList;
import java.util.List;

public class SearchDTO {
    public List<Track> trackList = new ArrayList<>();
    public List<User> userList = new ArrayList<>();
    public List<Playlist> playlistList = new ArrayList<>();

    public SearchDTO (){}

    public SearchDTO(List<Track> trackList, List<User> userList, List<Playlist> playlistList) {
        this.trackList = trackList;
        this.userList = userList;
        this.playlistList = playlistList;
    }
}
