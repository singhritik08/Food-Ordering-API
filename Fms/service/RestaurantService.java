package com.example.Fms.service;

import com.example.Fms.entity.model.FoodItem;
import com.example.Fms.entity.model.Restaurant;
import com.example.Fms.entity.request.DeleteRestaurantReq;
import com.example.Fms.entity.request.RestaurantRequest;
import com.example.Fms.entity.request.UpdateRestaurantReq;
import com.example.Fms.entity.response.RestaurantResponse;

import java.util.List;


public interface RestaurantService {
    Restaurant createRestaurant(RestaurantRequest restaurantRequest);

    boolean updateRestaurant(UpdateRestaurantReq updateReq);

    boolean deleteRestaurant(DeleteRestaurantReq deleteRequest);

    List<Restaurant> getRestaurants();

    void delete();

    Restaurant findByRestaurantId(Integer restaurantId);
    void saveUpdates(Restaurant restaurant);

    List<FoodItem> getFoodItemsByRestaurantId(int restaurantId);

    List<RestaurantResponse> getRestaurantsByOwnerId(int ownerId);

    void saveUpdated(Restaurant restaurant);
}
