package kz.iitu.wishlist.repository;

import kz.iitu.wishlist.model.entity.User;
import kz.iitu.wishlist.model.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    Optional<Wishlist> getByUser(User user);

}
