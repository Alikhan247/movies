package kz.iitu.order.service;

import kz.iitu.order.model.Movie;
import kz.iitu.order.model.Order;
import kz.iitu.order.repository.OrderRepository;
import kz.iitu.order.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public Order getOrder(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("There is no order with such id");
        }

        return orderRepository.findById(id).get();

    }

    public Order createOrder(Order order) {

        Order newOrder = new Order();

        if (!userRepository.existsById(order.getUser().getId())) {
            throw new RuntimeException("There is no user with such id");
        }

        newOrder.setUser(userRepository.findById(order.getUser().getId()).get());

        for (Movie movie : order.getMovies()) {
            Movie existingMovie = restTemplate.getForObject("http://movies-service/movie/" + movie.getId(), Movie.class);


            newOrder.getMovies().add(existingMovie);

        }

        return orderRepository.save(newOrder);

    }

    public Order payOrder(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("There is no order with such id");
        }

        Order order = orderRepository.findById(id).get();

        order.setPayedDate(LocalDateTime.now());

        return orderRepository.save(order);

    }

}
