package com.ecom.orderservice.service;

import com.ecom.orderservice.client.UserClient;
import com.ecom.orderservice.dto.OrderRequest;
import com.ecom.orderservice.dto.OrderResponse;
import com.ecom.orderservice.dto.UserResponse;
import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    public OrderService(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    public OrderResponse createOrder(OrderRequest request) {

        UserResponse user = userClient.getUserById(request.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());
        order.setStatus("CREATED");

        Order saved = orderRepository.save(order);

        return new OrderResponse(saved.getId(), saved.getStatus());
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
