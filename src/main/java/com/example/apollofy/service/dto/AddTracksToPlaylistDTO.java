package com.example.apollofy.service.dto;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public record AddTracksToPlaylistDTO(
        @NotNull List<Long> idTracks,
        Integer position) {
}
