package org.abbtech.practice.controller;

import lombok.RequiredArgsConstructor;
import org.abbtech.practice.entity.Order;
import org.abbtech.practice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order,
                                             @RequestHeader("X-USER-ID") String userId,
                                             @RequestHeader("X-USER-EMAIL") String userEmail) throws Exception {
        return ResponseEntity.ok(orderService.createOrder(order, userId, userEmail));
    }

    @PutMapping("/confirm/{id}")
    public ResponseEntity<Optional<Order>> confirmOrder(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.confirmOrder(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
