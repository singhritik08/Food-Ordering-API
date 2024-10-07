package com.example.Fms.service;

import com.example.Fms.entity.model.Order;
import com.example.Fms.entity.request.OrderRequest;
import com.example.Fms.entity.request.UpdateOrderStatusReq;
import com.example.Fms.entity.response.OrderResponse;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    boolean updateOrderStatus(UpdateOrderStatusReq statusReq);

    List<Order> gerOrdersByCustomerId(int customerId);

    List<Order> gerOrdersByRestaurantId(int restaurantId);

    List<Order> getOrders();

    void delete();

}
