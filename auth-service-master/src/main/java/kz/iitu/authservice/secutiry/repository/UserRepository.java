package kz.iitu.authservice.secutiry.repository;

import kz.iitu.authservice.secutiry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
