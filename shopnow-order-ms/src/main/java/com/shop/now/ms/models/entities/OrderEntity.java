package com.shop.now.ms.models.entities;

import com.shop.now.ms.models.dtos.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "orders")
public class OrderEntity {
    @Id
    private String id;
    private String orderName;
    private String orderType;
    private Object productDto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Object getProductDto() {
        return productDto;
    }

    public void setProductDto(Object productDto) {
        this.productDto = productDto;
    }
}
