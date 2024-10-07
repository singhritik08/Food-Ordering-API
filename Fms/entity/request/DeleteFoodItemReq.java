package com.example.Fms.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteFoodItemReq {
    private Integer restaurantId;
    private Integer foodId;
    private String ownerPhone;
}
