package com.ecom.orderservice.controller;

import com.ecom.orderservice.dto.OrderRequest;
import com.ecom.orderservice.dto.OrderResponse;
import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }
}
