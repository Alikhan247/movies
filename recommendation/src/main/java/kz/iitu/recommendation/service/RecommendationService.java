package kz.iitu.recommendation.service;

import kz.iitu.recommendation.model.dto.RecommendationsList;
import kz.iitu.recommendation.model.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RestTemplate restTemplate;

    public List<Movie> getRecommendation() {

        ResponseEntity<List<Movie>> recommendations =
                restTemplate.exchange("http://movies-service/movie/recommendations",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
                        });
        List<Movie> movieRecommendations = recommendations.getBody();

        return movieRecommendations;

    }

}
