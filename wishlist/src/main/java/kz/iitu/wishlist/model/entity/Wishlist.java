package kz.iitu.wishlist.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "wishlist_movies",
            joinColumns = {@JoinColumn(name = "wishlist_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")}
    )
    private Set<Movie> movies = new HashSet<>();

}