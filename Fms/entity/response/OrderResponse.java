package com.example.Fms.entity.response;

import com.example.Fms.entity.model.FoodItem;
import com.example.Fms.entity.model.OrderItems;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int orderId;
    private int customerId;
    private int restaurantId;
    private String orderStatus;
    private int quantity;
    private float totalPrice;

    private FoodItem foodItem;
}
