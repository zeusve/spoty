package com.example.apollofy.service;

import com.example.apollofy.domain.Track;
import com.example.apollofy.domain.User;
import com.example.apollofy.repository.TrackRepository;
import com.example.apollofy.service.dto.TrackDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor --> sirve para generar automáticamente el copnstructor a través de la librearía Lombok
public class TrackService {
    private final TrackRepository trackRepository;
    private final UserService userService;

    public TrackService(TrackRepository trackRepository, UserService userService) {

        this.trackRepository = trackRepository;
        this.userService = userService;
    }

    public Track createOneTrack(Long userId, TrackDTO trackDto) {
        User user = userService.getById(userId);

        Optional<Track> trackOptional = trackRepository.findTracksByNameIgnoreCase(trackDto.getName());
        if(trackOptional.isPresent()) throw new RuntimeException("Track named " + trackDto.getName() + " already exists");
        Track track = new Track(
                trackDto.getName(),
                trackDto.getDescription(),
                trackDto.getDuration(),
                trackDto.getReleasedDate(),
                user
        );
        return trackRepository.save(track);
    }

    public Track partialUpdateOneTrack(TrackDTO trackDto) {
        Optional<Track> trackOptional = trackRepository.findById(trackDto.getId());

        if(trackOptional.isEmpty()) throw new RuntimeException("Track id "+trackDto.getId()+" doesn't exist");

        Track track = trackOptional.get();
        if(trackDto.getName() != null) {
            track.setName(trackDto.getName());
        }
        if(trackDto.getDescription() != null) {
            track.setDescription(trackDto.getDescription());
        }
        if(trackDto.getDuration() != null) {
            track.setDuration(trackDto.getDuration());
        }
        if(trackDto.getReleasedDate() != null) {
            track.setReleasedDate(trackDto.getReleasedDate());
        }

        return trackRepository.save(track);
    }

    public void deleteTrackById(Long id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if(!trackRepository.existsById(id)) throw new RuntimeException("Entity Track not found in data base: entity not found");
        //Next message doesn't have sense because in the path we always have an id
        //if(trackOptional.isEmpty()) throw new RuntimeException("Track id "+id+" doesn't exist");
        Track track = trackOptional.get(); //bocadillo de tortilla
        trackRepository.delete(track);
    }

    public Track findById(Long idTrack) {
        Optional<Track> trackOptional = trackRepository.findById(idTrack);
        //ToDo: falta hacer gestión de errores, linea 62 con ExceptionHandlingAdvice
        Track track = trackOptional.get();
        return track;
    }

    //ToDo: crear un sistema de recomendaciones de canciones según los gustos del usuario. Ha de guardar el registro de las canciones que escucha (hacer un endpoint de las canciones que escucha), guardarlo
    //ToDo: hacer un proyecto desde cero que sea una red social. De manera que se vea si eres un contacto de primer, segundo o tercer nivel. Teoría de graphos (shortest path problem) Oscar Saavedra SocialNetwork repo. Tomar el camino mínimo que conecta a dos personas.


}

