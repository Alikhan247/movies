package kz.iitu.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    private String movieTrailer;

    private String movie;

    private String banner;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate = LocalDate.now();

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private double price;

    private int rating;

}
