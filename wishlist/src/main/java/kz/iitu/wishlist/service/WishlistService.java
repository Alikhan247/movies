package kz.iitu.wishlist.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.wishlist.model.entity.Movie;
import kz.iitu.wishlist.model.entity.User;
import kz.iitu.wishlist.model.entity.Wishlist;
import kz.iitu.wishlist.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor


@EnableHystrix
@EnableHystrixDashboard
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getWishlistByUserId",
            threadPoolKey = "getWishListMovies",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
    public Wishlist getWishlistByUserId(Long id){

        User user = restTemplate.getForObject("http://order-service/user/" + id, User.class);

        Optional<Wishlist> optionalWishlist = wishlistRepository.getByUser(user);

        if(optionalWishlist.isEmpty()){
           throw new RuntimeException("There is no wishlist");
        }

        return optionalWishlist.get();

    }

    @HystrixCommand(fallbackMethod = "createWishlist",
            threadPoolKey = "createWishListMovies",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
    public Wishlist createWishlist(Long userId){
        User user = restTemplate.getForObject("http://order-service/user/" + userId, User.class);

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);

        return wishlistRepository.save(wishlist);

    }

    @HystrixCommand(fallbackMethod = "addMoviesToWishlist",
            threadPoolKey = "createWishListMovies",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
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

    @HystrixCommand(fallbackMethod = "deleteMovieFromWishlist",
            threadPoolKey = "createWishListMovies",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
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
