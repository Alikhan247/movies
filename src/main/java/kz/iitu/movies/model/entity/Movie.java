package kz.iitu.movies.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;


    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime uploadDate = LocalDateTime.now();

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime releaseDate;

    private double price;

    private int rating;


}
