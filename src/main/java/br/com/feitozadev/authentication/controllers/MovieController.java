package br.com.feitozadev.authentication.controllers;

import br.com.feitozadev.authentication.domain.movies.Movie;
import br.com.feitozadev.authentication.domain.movies.MovieRequestDTO;
import br.com.feitozadev.authentication.domain.movies.MovieResponseDTO;
import br.com.feitozadev.authentication.repositories.MovieRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository repository;

    @PostMapping
    public ResponseEntity<MovieResponseDTO> save(@RequestBody @Valid MovieRequestDTO data) {
        Movie movie = new Movie(data);
        repository.save(movie);

        return ResponseEntity.ok(new MovieResponseDTO(movie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> getAll() {
        return ResponseEntity.ok(repository.findAll().stream().map(MovieResponseDTO::new).toList());
    }

}
