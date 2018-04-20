package com.pshenmic.mapstruct;

import com.pshenmic.domain.Order;
import com.pshenmic.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "address", target = "address")
    })
    OrderDTO toDTO(Order order);
}