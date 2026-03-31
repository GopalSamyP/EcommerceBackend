package com.ecom.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderResponse implements Serializable {
    private Long orderId;
    private String status;
}
