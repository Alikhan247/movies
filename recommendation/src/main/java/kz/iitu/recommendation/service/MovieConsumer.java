package kz.iitu.recommendation.service;

import kz.iitu.recommendation.model.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MovieConsumer {

    @KafkaListener(topics = "movie-created", groupId = "group_id")
    public void consume(Movie movie) throws IOException {
        System.out.println("Consuming event");
        System.out.println("Movie:" + movie.getName());


    }
}
