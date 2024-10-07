package com.example.Fms.repository;

import com.example.Fms.entity.model.Restaurant;
import com.example.Fms.entity.response.RestaurantResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    boolean existsByRestaurantPhone(String restaurantPhone);
    Restaurant findByRestaurantPhone(String restaurantPhone);

    boolean existsByRestaurantId(Integer restaurantId);

    Restaurant findByRestaurantId(Integer restaurantId);

   List<Restaurant> findByOwnerId(int ownerId);
}

