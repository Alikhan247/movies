package kz.iitu.movies.repository;

import kz.iitu.movies.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie ORDER BY rating LIMIT 10", nativeQuery = true)
    List<Movie> getRecommendations();


    List<Movie> findByNameContaining(String name);

}
