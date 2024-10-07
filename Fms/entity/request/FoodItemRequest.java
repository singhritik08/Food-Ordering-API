package com.example.Fms.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FoodItemRequest {
    private String ownerPhone;
    private int restaurantId;
    private String foodItemName;
    private String description;
    private float price;
}
