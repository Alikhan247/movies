package kz.iitu.wishlist.service;

import kz.iitu.wishlist.model.entity.Movie;
import kz.iitu.wishlist.model.entity.User;
import kz.iitu.wishlist.model.entity.Wishlist;
import kz.iitu.wishlist.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final RestTemplate restTemplate;

    public Wishlist getWishlistByUserId(Long id){

        User user = restTemplate.getForObject("http://order-service/user/" + id, User.class);

        Optional<Wishlist> optionalWishlist = wishlistRepository.getByUser(user);

        if(optionalWishlist.isEmpty()){
           throw new RuntimeException("There is no wishlist");
        }

        return optionalWishlist.get();

    }

    public Wishlist createWishlist(Long userId){
        User user = restTemplate.getForObject("http://order-service/user/" + userId, User.class);

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);

        return wishlistRepository.save(wishlist);

    }

    public Wishlist addMoviesToWishlist(Long userId, Long movieId){

        User user = restTemplate.getForObject("http://order-service/user/" + userId, User.class);

        Optional<Wishlist> optionalWishlist = wishlistRepository.getByUser(user);

        if(optionalWishlist.isEmpty()){
            throw new RuntimeException("There is no wishlist");
        }

        Wishlist wishlist = optionalWishlist.get();

        Movie movie = restTemplate.getForObject("http://movies-service/movie/" + movieId, Movie.class);

        wishlist.getMovies().add(movie);

        return wishlistRepository.save(wishlist);

    }

    public Wishlist deleteMovieFromWishlist(Long userId, Long movieId){

        User user = restTemplate.getForObject("http://order-service/user/" + userId, User.class);

        Optional<Wishlist> optionalWishlist = wishlistRepository.getByUser(user);

        if(optionalWishlist.isEmpty()){
            throw new RuntimeException("There is no wishlist");
        }

        Wishlist wishlist = optionalWishlist.get();

        Movie movie = restTemplate.getForObject("http://movies-service/movie/" + movieId, Movie.class);

        wishlist.getMovies().remove(movie);

        return wishlistRepository.save(wishlist);

    }

}
