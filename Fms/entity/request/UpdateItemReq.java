package com.example.Fms.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateItemReq {
    private int foodId;
    private int restaurantId;
    private String ownerPhone;
    private String foodItemName;
    private String description;
    private float price;

}
