package kz.iitu.authservice.secutiry;

import kz.iitu.authservice.secutiry.entity.User;
import kz.iitu.authservice.secutiry.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findById(Long.valueOf(id));
        if (user.isEmpty())
            throw new UsernameNotFoundException("User with id: " + id + " is not found");

        return user.get();
    }

}
