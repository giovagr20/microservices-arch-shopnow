package com.shop.now.ms.controllers;

import com.shop.now.ms.exceptions.NotFoundException;
import com.shop.now.ms.models.dtos.OrderDto;
import com.shop.now.ms.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Controller to handle order operations")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @Operation(summary = "Endpoint to create new orders")
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok()
                .body(orderService.createOrder(orderDto)
                        .orElseThrow(NotFoundException::new));
    }
}
