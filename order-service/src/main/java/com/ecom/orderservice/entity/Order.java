package com.ecom.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String productName;

    private int quantity;

    private double price;

    private String status; // CREATED, PAID, CANCELLED
}
