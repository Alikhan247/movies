package kz.iitu.recommendation.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import kz.iitu.recommendation.model.dto.RecommendationsList;
import kz.iitu.recommendation.model.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor

@EnableHystrix
@EnableHystrixDashboard
public class RecommendationService {

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getRecommendation",
            threadPoolKey = "getMoviesRecommendation",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
    public List<Movie> getRecommendation() {

        ResponseEntity<List<Movie>> recommendations =
                restTemplate.exchange("http://movies-service/movie/recommendations",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
                        });
        List<Movie> movieRecommendations = recommendations.getBody();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return movieRecommendations;

    }

}
