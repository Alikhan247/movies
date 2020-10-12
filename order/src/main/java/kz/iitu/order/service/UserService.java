package kz.iitu.order.service;

import kz.iitu.order.model.User;
import kz.iitu.order.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("There is no user with such id");
        }

        return userRepository.findById(id).get();

    }

    public User createUser(User user) {

        return userRepository.save(user);

    }


}
