package com.example.apollofy.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.apollofy.domain.Track} entity
 */
@Data
public class TrackDTO implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final Long duration;
    private final LocalDate releasedDate;

}