package kz.iitu.wishlist.controller;

import kz.iitu.wishlist.model.entity.Wishlist;
import kz.iitu.wishlist.repository.WishlistRepository;
import kz.iitu.wishlist.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("*")
public class WishlistController {

    private final WishlistService wishlistService;
    private final WishlistRepository wishlistRepository;

    @GetMapping("/wishlist/{userId}")
    public ResponseEntity<Wishlist> getWishlist(@PathVariable Long userId) {
        return new ResponseEntity<>(wishlistService.getWishlistByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/wishlist/list")
    public ResponseEntity<List<Wishlist>> getMovie() {
        return new ResponseEntity<>(wishlistRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/wishlist/add/{userId}/{movieId}")
    public ResponseEntity<Wishlist> createMovie(@PathVariable Long userId, @PathVariable Long movieId) {
        return new ResponseEntity<>(wishlistService.addMoviesToWishlist(userId, movieId), HttpStatus.CREATED);
    }

    @PutMapping("/wishlist/delete/{userId}/{movieId}")
    public ResponseEntity<Wishlist> deleteMovie(@PathVariable Long userId, @PathVariable Long movieId) {
        return new ResponseEntity<>(wishlistService.deleteMovieFromWishlist(userId, movieId), HttpStatus.CREATED);
    }

    @PostMapping("/wishlist/{userId}")
    public ResponseEntity<Wishlist> createMovie(@PathVariable Long userId) {
        return new ResponseEntity<>(wishlistService.createWishlist(userId), HttpStatus.CREATED);
    }


}
