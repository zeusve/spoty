package com.example.apollofy;

import com.example.apollofy.domain.Genre;
import com.example.apollofy.domain.Playlist;
import com.example.apollofy.domain.Track;
import com.example.apollofy.domain.User;
import com.example.apollofy.repository.GenreRepository;
import com.example.apollofy.repository.PlaylistRepository;
import com.example.apollofy.repository.TrackRepository;
import com.example.apollofy.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class ApollofyApplication implements CommandLineRunner {

	private final GenreRepository genreRepository;
	private final UserRepository userRepository;
	private final TrackRepository trackRepository;
	private final PlaylistRepository playlistRepository;

	public ApollofyApplication(GenreRepository genreRepository, UserRepository userRepository, TrackRepository trackRepository, PlaylistRepository playlistRepository) {
		this.genreRepository = genreRepository;
		this.userRepository = userRepository;
		this.trackRepository = trackRepository;
		this.playlistRepository = playlistRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApollofyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//create genre in bbdd
		Genre rock = new Genre("Rock");
		Genre pop = new Genre("Pop");
		Genre heavy = new Genre("Heavy");
		genreRepository.save(rock);
		genreRepository.save(pop);
		genreRepository.save(heavy);
		//create user in bbdd
		User zeus = new User ("Zeus", "VE", "XXXX@gmail.com");
		userRepository.save(zeus);
		//create tracks in bbdd
		Track track1 = new Track("Angel","Third single of Permanent Vacation", 350L, LocalDate.of(1987,01,04), zeus);
		Track track2 = new Track("Beautiful Day","About a beautiful day in the beach",400L, LocalDate.of(1996,12,15), zeus);
		track2.addGenre(rock);
		track2.addGenre(heavy);
		Track track3 = new Track("My brown eye girl", "The song of my life",350L, LocalDate.of(1967,02,15), zeus);
		track3.addGenre(rock);
		track3.addGenre(pop);
		Track track4 = new Track("Somni", "Kid's song",350L, LocalDate.of(2022,02,15), zeus,
				Arrays.asList(new Genre[]{rock, pop, heavy}));
		trackRepository.save(track1);
		trackRepository.save(track2);
		trackRepository.save(track3);
		trackRepository.save(track4);
		//create playlist in bbdd
		Playlist playlist1 = new Playlist("Relax", "pels meus moments", true);
		playlist1.addTrack(track1);
		playlist1.addTrack(track2);
		playlist1.addCollaborator(zeus);
		playlistRepository.save(playlist1);



		//pero ahora falta especificar con qué base de datos trabajamos --> application.properties
		//googlear --> Spring Boot postgree application properties

		System.out.println("Finished");

	}
}
