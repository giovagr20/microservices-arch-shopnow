package com.shop.now.ms.services;

import com.shop.now.ms.clients.ProductClient;
import com.shop.now.ms.models.dtos.OrderDto;
import com.shop.now.ms.models.dtos.ProductDto;
import com.shop.now.ms.models.mappers.OrderMapper;
import com.shop.now.ms.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    @Override
    public Optional<OrderDto> createOrder(OrderDto orderDto) {
        Object product = productClient.getProductById("9e9a0b42-35db-4701-ab4f-6e15fca33f52").getBody();
        orderDto.setProductDto(product);
        var result = orderRepository.save(orderMapper.toOrderEntity(orderDto));
        return Optional.ofNullable(orderMapper.toOrderDto(result));
    }

    @Override
    public Optional<List<OrderDto>> getOrders() {
        return Optional.empty();
    }

    @Override
    public Optional<OrderDto> getOrderById(UUID id) {
        return Optional.empty();
    }
}
