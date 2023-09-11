package com.shop.now.ms.models.mappers;

import com.shop.now.ms.models.dtos.OrderDto;
import com.shop.now.ms.models.entities.OrderEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    @Mapping(source = "orderName", target = "orderName")
    @Mapping(source = "orderType", target = "orderType")
    @Mapping(source = "productDto", target = "productDto")
    @Mapping(source = "id", target = "id")
    OrderDto toOrderDto(OrderEntity orderEntity);

    @Mapping(source = "orderName", target = "orderName")
    @Mapping(source = "orderType", target = "orderType")
    @Mapping(source = "productDto", target = "productDto")
    @Mapping(source = "id", target = "id")
    OrderEntity toOrderEntity(OrderDto orderDto);

    default List<OrderDto> toListOrderDto(List<OrderEntity> orderEntities) {
        return orderEntities
                .stream()
                .map(this::toOrderDto)
                .toList();
    }

    default List<OrderEntity> toOrderEntity(List<OrderDto> orderDtos) {
        return orderDtos
                .stream()
                .map(this::toOrderEntity)
                .toList();
    }
}
