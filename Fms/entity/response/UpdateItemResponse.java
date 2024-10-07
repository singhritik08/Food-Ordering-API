package com.example.Fms.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateItemResponse {
    private Integer restaurantId;
    private String restaurantName;
    private String foodItemName;
    private Boolean foodItemStatus;
}
