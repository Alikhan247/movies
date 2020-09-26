package kz.iitu.movies.service;

import kz.iitu.movies.model.entity.Movie;
import kz.iitu.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        Movie mov;

        mov = movieRepository.save(movie);
        mov.setId(mov.getId());

        return mov;

    }

    public Movie getMovie(Long id){

        if(!movieRepository.existsById(id)){

            System.out.println("No emplyee with given id found");
        }

        return movieRepository.findById(id).get();

    }



}
