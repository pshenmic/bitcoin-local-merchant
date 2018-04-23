package com.pshenmic.service;


import com.pshenmic.domain.Order;
import com.pshenmic.domain.Product;
import com.pshenmic.enums.OrderStatus;
import com.pshenmic.mapstruct.OrderMapper;
import com.pshenmic.mapstruct.OrderStatusMapper;
import com.pshenmic.mapstruct.ProductListMapper;
import com.pshenmic.mapstruct.ProductMapper;
import com.pshenmic.model.dto.OrderDTO;
import com.pshenmic.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductListMapper productListMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    public ProductDTO toDTO(Product product) {
        return productMapper.toDTO(product);
    }

    public OrderDTO toDTO(Order order) {
        return orderMapper.toDTO(order);
    }

    public List<ProductDTO> toDTO(List<Product> products) {
        return productListMapper.toDTO(products);
    }

    public OrderStatus toOrderStatus(String status) {
        return orderStatusMapper.fromStringToOrderStatus(status);
    }

}
