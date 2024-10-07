package com.example.Fms.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateItemStatus {
    private Integer restaurantId;
    private Integer foodId;
    private Integer ownerId;
    private Boolean availability;

}
