package com.shop.now.ms.services;

import com.shop.now.ms.models.dtos.OrderDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {

    Optional<OrderDto> createOrder(OrderDto orderDto);
    Optional<List<OrderDto>> getOrders();
    Optional<OrderDto> getOrderById(UUID id);
}
