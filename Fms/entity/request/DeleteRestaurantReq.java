package com.example.Fms.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteRestaurantReq {
    private int ownerId;
    private String restaurantPhone;
}
