package com.example.Fms.entity.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @JsonIdentityReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "FOOD_ITEM_ID")
    private FoodItem foodItem;

    private Integer quantity;

    private Float totalPrice;

}
