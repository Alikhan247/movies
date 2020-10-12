package kz.iitu.recommendation.controller;

import kz.iitu.recommendation.model.entity.Movie;
import kz.iitu.recommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public ResponseEntity<List<Movie>> getRecommendation() {
        return new ResponseEntity<>(recommendationService.getRecommendation(), HttpStatus.OK);
    }

}
