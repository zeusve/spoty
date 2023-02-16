package com.example.apollofy.service.dto;

import com.example.apollofy.domain.Playlist;
import com.example.apollofy.domain.Track;
import com.example.apollofy.domain.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

@Data
public class SearchDTO implements Serializable {
    @NotNull List<Track> trackList;
    @NotNull List<User> userList;
    @NotNull List<Playlist> playlistList;

    public SearchDTO (){}

    public SearchDTO(List<Track> trackList, List<User> userList, List<Playlist> playlistList) {
        this.trackList = trackList;
        this.userList = userList;
        this.playlistList = playlistList;

    }

}
