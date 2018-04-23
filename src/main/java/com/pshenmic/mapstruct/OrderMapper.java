package com.pshenmic.mapstruct;

import com.pshenmic.domain.Order;
import com.pshenmic.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OrderMapper {


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "product", target = "product"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "time", target = "time"),
            @Mapping(source = "operationPrice", target = "operationPrice"),
            @Mapping(source = "status", target = "status")
    })
    OrderDTO toDTO(Order order);
}