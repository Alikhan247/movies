package kz.iitu.movies.service;

import kz.iitu.movies.model.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieProducer {
    private static final String TOPIC = "movie-created";

    private final KafkaTemplate<String, Movie> kafkaTemplate;

    public void bookAdded(Movie order){
        System.out.println("Producing new event");
        this.kafkaTemplate.send(TOPIC, order);
    }
}
