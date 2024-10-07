package com.example.Fms.entity.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantResponse {
    private int restaurantId;
    private String restaurantPhone;
    private String restaurantName;
    private String restaurantAddress;
    private boolean availableRestaurant;

}
