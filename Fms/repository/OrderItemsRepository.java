package com.example.Fms.repository;

import com.example.Fms.entity.model.FoodItem;
import com.example.Fms.entity.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer> {
    void deleteByFoodItem(FoodItem foodItem);
}
