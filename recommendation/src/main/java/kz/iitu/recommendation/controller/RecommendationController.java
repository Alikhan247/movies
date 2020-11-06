package kz.iitu.recommendation.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.recommendation.model.entity.Movie;
import kz.iitu.recommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
//@EnableCircuitBreaker
public class RecommendationController {

    private final RecommendationService recommendationService;


    @GetMapping("/recommendation")
    public ResponseEntity<List<Movie>> getRecommendation() {
        return new ResponseEntity<>(recommendationService.getRecommendation(), HttpStatus.OK);
    }

}
