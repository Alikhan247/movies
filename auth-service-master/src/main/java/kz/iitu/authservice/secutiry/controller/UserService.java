package kz.iitu.authservice.secutiry.controller;


import kz.iitu.authservice.secutiry.entity.User;
import kz.iitu.authservice.secutiry.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Component
public class UserService  {

    private UserRepository userRepository;

    public Optional<User> findUserById(Long id) {
        System.out.println("Test");
        return userRepository.findById(id);
    }


    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        System.out.println(user.getUsername());
        return userRepository.save(user);
    }

//    public User findByUsername(String name) {
//        return userRepository.findByUsername(name);
//    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
