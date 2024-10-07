package com.example.Fms.entity.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantRequest {
    private String ownerPhone;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
}
