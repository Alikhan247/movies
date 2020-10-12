package kz.iitu.recommendation.model.dto;

import kz.iitu.recommendation.model.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationsList {

    private List<Movie> movies;

}
