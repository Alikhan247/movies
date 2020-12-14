package kz.iitu.movies.controller;

import kz.iitu.movies.model.entity.Movie;
import kz.iitu.movies.repository.MovieRepository;
import kz.iitu.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("*")
public class MoviesController {

    private final MovieService movieService;
    private final MovieRepository movieRepository;

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.getMovie(id), HttpStatus.OK);
    }

    @GetMapping("/movie/find/{name}")
    public ResponseEntity<List<Movie>> getMovie(@PathVariable String name) {
        return new ResponseEntity<>(movieService.searchMovies(name), HttpStatus.OK);
    }

    @GetMapping("/movie/recommendations")
    public ResponseEntity<List<Movie>> getRecommendations() {
        return new ResponseEntity<>(movieService.getRecommendations(), HttpStatus.OK);
    }

    @GetMapping("/movie/list")
    public ResponseEntity<List<Movie>> getMovie() {
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

}
