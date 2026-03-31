package com.ecom.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderRequest implements Serializable {
    @NotNull
    private Long userId;
    @NotBlank
    private String productName;
    @NotNull
    @Min(1)
    private int quantity;
    @NotNull
    @Min(1)
    private double price;
}
