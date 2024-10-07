package com.example.Fms.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity(name = "foodItem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer foodId;
    private Integer restaurantId;
    private String itemName;
    private String description;
    private Float price;
    private Boolean availability;
}
