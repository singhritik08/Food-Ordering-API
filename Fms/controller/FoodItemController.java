package com.example.Fms.controller;

import com.example.Fms.entity.model.FoodItem;
import com.example.Fms.entity.request.DeleteFoodItemReq;
import com.example.Fms.entity.request.FoodItemRequest;
import com.example.Fms.entity.request.UpdateItemReq;
import com.example.Fms.entity.request.UpdateItemStatus;
import com.example.Fms.entity.response.UpdateItemResponse;
import com.example.Fms.service.FoodItemService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/foodItems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/create/foodItem")
    public FoodItem createFoodItem(@RequestBody FoodItemRequest foodItemRequest){
        return foodItemService.createFoodItem(foodItemRequest);
    }

    @PutMapping("/update/foodItem")
    public boolean updateFoodItem(@RequestBody UpdateItemReq updateItemReq) {
        return foodItemService.updateFoodItem(updateItemReq);
    }

    @DeleteMapping("/delete/foodItem")
    public boolean deleteFoodItem(@RequestBody DeleteFoodItemReq foodItemReq) {
        return foodItemService.deleteFoodItem(foodItemReq);
    }

    @GetMapping("/all/foodItem")
    public List<FoodItem> getFoodItems () {
        return foodItemService.getFoodItems();
    }

    @GetMapping("/foodItems/details")
    public FoodItem getFoodItemDetailsByFoodId(@RequestParam int foodId) {
        return foodItemService.getFoodItemDetailsByFoodId(foodId);
    }

    @DeleteMapping("/wipe/foodItem/all")
    public void delete(){
        foodItemService.delete();
    }

    @PutMapping("/update/item/status")
    public UpdateItemResponse updateItemStatusByRestaurant(@RequestBody UpdateItemStatus itemStatus) {
        return foodItemService.updateItemStatusByRestaurant(itemStatus);
    }

}
