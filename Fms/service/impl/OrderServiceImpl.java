package com.example.Fms.service.impl;

import com.example.Fms.entity.model.*;
import com.example.Fms.entity.request.OrderRequest;
import com.example.Fms.entity.request.UpdateOrderStatusReq;
import com.example.Fms.entity.response.OrderResponse;
import com.example.Fms.repository.OrderRepository;
import com.example.Fms.service.FoodItemService;
import com.example.Fms.service.OrderService;
import com.example.Fms.service.RestaurantService;
import com.example.Fms.service.UserService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private RestaurantService restaurantService;


    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Optional<User> user = userService.findById(orderRequest.getCustomerId());
        if (user.isPresent()) {
            Restaurant restaurant = restaurantService.findByRestaurantId(orderRequest.getRestaurantId());
            if (restaurant != null) {

                FoodItem foodItem = foodItemService.findByFoodId(orderRequest.getFoodId());
                if (foodItem != null) {
                    if (foodItem.getAvailability()) {
                        if (orderRequest.getQuantity() > 0) {
                            Order order = new Order();
                            order.setCustomerId(orderRequest.getCustomerId());
                            order.setRestaurantId(orderRequest.getRestaurantId());
                            order.setStatus("In-progress");

                            OrderItems orderItem = new OrderItems();
                            orderItem.setOrder(order);
                            orderItem.setFoodItem(foodItem);
                            orderItem.setQuantity(orderRequest.getQuantity());
                            orderItem.setTotalPrice(foodItem.getPrice() * orderRequest.getQuantity());

                            List<OrderItems> orderItems = new ArrayList<>();
                           orderItems.add(orderItem);

                            if (orderRequest.getQuantity() > 1) {
                                for (int i = 1; i < orderRequest.getQuantity(); i++) {
                                    OrderItems additionalOrderItem = new OrderItems();
                                    additionalOrderItem.setOrder(order);
                                    additionalOrderItem.setFoodItem(foodItem);
                                    additionalOrderItem.setQuantity(1);
                                    additionalOrderItem.setTotalPrice(foodItem.getPrice());
                                    orderItems.add(additionalOrderItem);

                                }
                            }

                            order.setOrderItems(orderItems);
                            order = orderRepository.save(order);

                            OrderResponse orderResponse = new OrderResponse();
                            orderResponse.setOrderId(order.getOrderId());
                            orderResponse.setCustomerId(order.getCustomerId());
                            orderResponse.setRestaurantId(order.getRestaurantId());
                            orderResponse.setOrderStatus(order.getStatus());
                            orderResponse.setQuantity(orderRequest.getQuantity());
                            orderResponse.setTotalPrice(foodItem.getPrice() * orderRequest.getQuantity());
                            orderResponse.setFoodItem(foodItem);

                            return orderResponse;
                        } else {
                            return new OrderResponse();
                        }
                    }
                    else {
                        return new OrderResponse();
                    }
                } else {
                    return new OrderResponse();
                }
            } else {
                return new OrderResponse();
            }
        } else {
            return new OrderResponse();
        }
    }


    @Override
    public boolean updateOrderStatus(UpdateOrderStatusReq statusReq) {
        Order order = orderRepository.findByOrderId(statusReq.getOrderId());
        if (order != null) {
            if (statusReq.getStatus().equalsIgnoreCase("complete") || statusReq.getStatus().equalsIgnoreCase("pending")) {
                order.setStatus(statusReq.getStatus());
                orderRepository.save(order);
                return true;
            } else {
                // when status is not valid.
                return false;
            }
        } else {
            // when orderId not found.
            return false;
        }
    }

    @Override
    public List<Order> gerOrdersByCustomerId(int customerId) {
        List<Order> orderList = orderRepository.findAllByCustomerId(customerId);
        if (!orderList.isEmpty()) {
            return orderList;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Order> gerOrdersByRestaurantId(int restaurantId) {
        List<Order> orderList = orderRepository.findAllByRestaurantId(restaurantId);
        if (!orderList.isEmpty()) {
            return orderList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void delete() {
        orderRepository.deleteAll();
    }


}
