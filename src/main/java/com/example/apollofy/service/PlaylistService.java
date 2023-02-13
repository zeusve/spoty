package com.example.apollofy.service;

import com.example.apollofy.domain.Playlist;
import com.example.apollofy.domain.Track;
import com.example.apollofy.repository.PlaylistRepository;
import com.example.apollofy.service.dto.AddTracksToPlaylistDTO;
import com.example.apollofy.service.dto.PlaylistDTO;
import com.example.apollofy.utilites.ElementNotFoundException;
import com.example.apollofy.utilites.PlaylistAlreadyExistsException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;


@Service
@Transactional
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private TrackService trackService;

    public PlaylistService(PlaylistRepository playlistRepository, TrackService trackService) {
        this.playlistRepository = playlistRepository;
        this.trackService = trackService;
    }

    public Playlist createOnePlaylist(PlaylistDTO playlistDTO) {
        Optional<Playlist> playlistOptional = playlistRepository.findPlaylistByNameIgnoreCase(playlistDTO.name());
        if(playlistOptional.isPresent()) throw new PlaylistAlreadyExistsException(playlistDTO.name());
        Playlist playlist = new Playlist(playlistDTO);
        return playlistRepository.save(playlist);
    }

    public Playlist updateOnePlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = getPlaylist(playlistDTO.id());
        playlist.setName(playlistDTO.name());
        playlist.setDescription(playlistDTO.description());
        playlist.setIsPublic(playlistDTO.isPublic());
        return playlistRepository.save(playlist);
    }

    public Playlist patchPlaylist(PlaylistDTO playlistDTO) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(playlistDTO.id());
        if(playlistOptional.isEmpty()) throw new RuntimeException("Playlist id "+playlistDTO.id()+" doesn't exist");
        Playlist playlist = playlistOptional.get();
        if(playlistDTO.name() != null ) playlist.setName(playlistDTO.name());
        if(playlistDTO.description() != null ) playlist.setDescription(playlistDTO.description());
        if(playlistDTO.isPublic() != null) playlist.setIsPublic(playlistDTO.isPublic());
        return playlistRepository.save(playlist);
    }

    public Playlist addTracks(Long id, AddTracksToPlaylistDTO addTracksToPlaylistDTO) {
        Playlist playlist = playlistRepository.findById(id).get();
        var currentTracks = playlist.getTracks();

        List<Track> tracksToAdd = new ArrayList<>();

        for (Long idTrack : addTracksToPlaylistDTO.idTracks()) {
            Track trackToAdd = trackService.findById(idTrack);
            tracksToAdd.add(trackToAdd);
        }

        if(addTracksToPlaylistDTO.position() != null) {
            currentTracks.addAll(addTracksToPlaylistDTO.position(),tracksToAdd);
        } else currentTracks.addAll(tracksToAdd);
        return playlist;
    }

    public Playlist getPlaylist (Long id) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(id);
        if(playlistOptional.isEmpty()) throw new ElementNotFoundException(Playlist.class,id);
        Playlist playlist = playlistOptional.get();
        return playlist;
    }
}
