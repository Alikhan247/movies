package kz.iitu.movies.service;

import kz.iitu.movies.model.entity.Movie;
import kz.iitu.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieProducer movieProducer;

    public Movie addMovie(Movie movie) {
        movieProducer.bookAdded(movie);
        return movieRepository.save(movie);

    }

    public Movie getMovie(Long id) {

        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("No movie with given id found");
        }
        return movieRepository.findById(id).get();

    }

    public List<Movie> getRecommendations() {
        return movieRepository.getRecommendations();
    }

    public List<Movie> searchMovies(String name) {
        return movieRepository.findByNameContaining(name);
    }


}
