package com.example.apollofy.service.dto;

import com.example.apollofy.domain.Playlist;
import com.example.apollofy.domain.Track;
import com.example.apollofy.domain.User;
import javax.validation.constraints.NotNull;
import java.util.List;

public class SearchDTO {
    @NotNull private List<Track> trackList;
    @NotNull private List<User> userList;
    @NotNull private List<Playlist> playlistList;

    public SearchDTO (){}

    public SearchDTO(List<Track> trackList, List<User> userList, List<Playlist> playlistList) {
        this.trackList = trackList;
        this.userList = userList;
        this.playlistList = playlistList;
        System.out.println("canciones "+this.trackList);
        System.out.println("users "+this.userList);
        System.out.println("play list "+this.playlistList);
    }

    @Override
    public String toString() {
        return "{" +
                "trackList=" + trackList +
                ", userList=" + userList +
                ", playlistList=" + playlistList +
                '}';
    }
}
