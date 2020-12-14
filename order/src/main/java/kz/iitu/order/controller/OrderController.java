package kz.iitu.order.controller;

import kz.iitu.order.model.Order;
import kz.iitu.order.repository.OrderRepository;
import kz.iitu.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }

    @GetMapping("/order/list")
    public ResponseEntity<List<Order>> getMovie() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createMovie(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/order/pay/{id}")
    public ResponseEntity<Order> createMovie(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.payOrder(id), HttpStatus.OK);
    }

}
