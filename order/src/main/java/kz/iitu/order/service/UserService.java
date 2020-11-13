package kz.iitu.order.service;

import kz.iitu.order.model.Role;
import kz.iitu.order.model.User;
import kz.iitu.order.repository.RoleRepository;
import kz.iitu.order.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private RoleRepository roleRepository;

    public User getUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("There is no user with such id");
        }

        return userRepository.findById(id).get();

    }

    public User createUser(User user) {

        return userRepository.save(user);

    }

    public User saveUser(User user)  {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(user.getRole());
        System.out.println(userRole);
        if (userRole != null) {
            roles.add(userRole);
        }
        user.setRoles(roles);
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }


}
