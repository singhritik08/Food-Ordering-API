package com.example.Fms.controller;

import com.example.Fms.entity.model.Order;
import com.example.Fms.entity.request.OrderRequest;
import com.example.Fms.entity.request.UpdateOrderStatusReq;
import com.example.Fms.entity.response.OrderResponse;
import com.example.Fms.repository.OrderItemsRepository;
import com.example.Fms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food_order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @PostMapping("/place/order")
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
    @PutMapping("/update/order/status")
    public boolean updateOrderStatus(@RequestBody UpdateOrderStatusReq statusReq) {
        return orderService.updateOrderStatus(statusReq);
    }

    @GetMapping("/orders/customer")
    public List<Order> gerOrdersByCustomerId(@RequestParam int customerId) {
        return orderService.gerOrdersByCustomerId(customerId);
    }

    @GetMapping("/orders/restaurant")
    public List<Order> gerOrdersByRestaurantId(@RequestParam int restaurantId) {
        return orderService.gerOrdersByRestaurantId(restaurantId);
    }

    @GetMapping("/all/orders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @DeleteMapping("/wipe/all/orders")
    public void delete(){
        orderService.delete();
    }
}
