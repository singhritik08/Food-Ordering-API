package com.example.Fms.repository;

import com.example.Fms.entity.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findByOrderId(int orderId);

    List<Order> findAllByRestaurantId(int restaurantId);

    List<Order> findAllByCustomerId(int customerId);

    List<Order> findByRestaurantId(Integer restaurantId);
}
