package org.abbtech.practice.service;

import lombok.RequiredArgsConstructor;
import org.abbtech.practice.client.BookClient;
import org.abbtech.practice.entity.Order;
import org.abbtech.practice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private final BookClient bookFeignClient;

//    private final KafkaTemplate<String, String> kafkaTemplate;

    public Order createOrder(Order order, String userId, String userEmail) throws Exception {

        Book book = bookFeignClient.getBookById(order.getBookId());
        if (book == null) {
            throw new Exception("Book not found");
        }
        order.setId(UUID.randomUUID());
        order.setUserId(UUID.fromString(userId));
        Order savedOrder = orderRepository.save(order);
        // Send notification
//        kafkaTemplate.send("order-events", "Order created: " + savedOrder.getId());
        return savedOrder;
    }

    public Optional<Order> confirmOrder(UUID orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        // Publish event to Kafka
//        kafkaTemplate.send("order-events", "Order confirmed: " + orderId);
        return order;
    }

    public Optional<Order> getOrderById(UUID id) {
        return orderRepository.findById(id);
    }
}

