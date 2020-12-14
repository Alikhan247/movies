package kz.alikhan.trailer.controller;

import kz.alikhan.trailer.entity.TrailerDTO;
import kz.alikhan.trailer.repository.MovieRepository;
import kz.alikhan.trailer.entity.Movie;
import kz.alikhan.trailer.entity.Movie;
import kz.alikhan.trailer.service.MovieService;
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

    @GetMapping("/trailer/{id}")
    public ResponseEntity<TrailerDTO> getMovie(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.getRecommendation(id), HttpStatus.OK);
    }

}
