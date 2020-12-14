package kz.alikhan.trailer.service;

import kz.alikhan.trailer.entity.Movie;
import kz.alikhan.trailer.entity.TrailerDTO;
import kz.alikhan.trailer.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie getMovie(Long id) {

        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("No movie with given id found");
        }
        return movieRepository.findById(id).get();

    }


    private final RestTemplate restTemplate;

    public TrailerDTO getRecommendation(Long id) {

        ResponseEntity<Movie> movie =
                restTemplate.exchange("http://movies-service/movie/"+id,
                        HttpMethod.GET, null, new ParameterizedTypeReference<Movie>() {
                        });

        TrailerDTO trailer = new TrailerDTO();
        String trialer = movie.getBody().getMovieTrailer();
        trailer.setMovieTrailer(trialer);
        System.out.println(trialer);

        return trailer;
    }

}
