package com.example.Fms.controller;

import com.example.Fms.entity.model.FoodItem;
import com.example.Fms.entity.model.Restaurant;
import com.example.Fms.entity.request.DeleteRestaurantReq;
import com.example.Fms.entity.request.RestaurantRequest;
import com.example.Fms.entity.request.UpdateRestaurantReq;
import com.example.Fms.entity.response.RestaurantResponse;
import com.example.Fms.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create/restaurant")
    public Restaurant createRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        return restaurantService.createRestaurant(restaurantRequest);
    }

    @PutMapping("/update/restaurant")
    public boolean updateRestaurant(@RequestBody UpdateRestaurantReq updateReq) {
        return restaurantService.updateRestaurant(updateReq);
    }

    @DeleteMapping("/delete/restaurant")
    public boolean deleteRestaurant(@RequestBody DeleteRestaurantReq deleteRequest) {
        return restaurantService.deleteRestaurant(deleteRequest);
    }

    @GetMapping("/all/restaurant")
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @DeleteMapping("/wipe/all/restaurantData")
    public void delete() {
        restaurantService.delete();
    }

    @GetMapping("/fooItem/List")
    public List<FoodItem> getFoodItemsByRestaurantId(@RequestParam int restaurantId) {
        return restaurantService.getFoodItemsByRestaurantId(restaurantId);
    }

    @GetMapping("/restaurants/byOwner")
    public List<RestaurantResponse> getRestaurantsByOwnerId(@RequestParam int ownerId) {
        return restaurantService.getRestaurantsByOwnerId(ownerId);
    }
}
