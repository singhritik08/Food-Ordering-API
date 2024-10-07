package com.example.Fms.service;

import com.example.Fms.entity.model.FoodItem;
import com.example.Fms.entity.request.DeleteFoodItemReq;
import com.example.Fms.entity.request.FoodItemRequest;
import com.example.Fms.entity.request.UpdateItemReq;
import com.example.Fms.entity.request.UpdateItemStatus;
import com.example.Fms.entity.response.UpdateItemResponse;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    FoodItem createFoodItem(FoodItemRequest foodItemRequest);

    boolean updateFoodItem(UpdateItemReq updateItemReq);

    boolean deleteFoodItem(DeleteFoodItemReq foodItemReq);

    List<FoodItem> getFoodItems();

    FoodItem findByFoodId(Integer foodId);

    FoodItem getFoodItemDetailsByFoodId(int foodId);

    void delete();


    UpdateItemResponse updateItemStatusByRestaurant(UpdateItemStatus itemStatus);
}
