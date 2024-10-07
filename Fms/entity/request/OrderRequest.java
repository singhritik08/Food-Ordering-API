package com.example.Fms.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {
    private int customerId;
    private int restaurantId;
    private int foodId;
    private int quantity;
}
