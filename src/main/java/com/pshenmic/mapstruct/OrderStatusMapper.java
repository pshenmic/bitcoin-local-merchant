package com.pshenmic.mapstruct;

import com.pshenmic.enums.OrderStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {


    default OrderStatus fromStringToOrderStatus(String status) {
        try {
            return OrderStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}