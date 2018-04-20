package com.pshenmic.controller;

import com.pshenmic.api.rest.OrderAPI;
import com.pshenmic.domain.Order;
import com.pshenmic.model.dto.OrderDTO;
import com.pshenmic.model.electrum.SendRequest;
import com.pshenmic.service.ElectrumService;
import com.pshenmic.service.MappingService;
import com.pshenmic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RestController
@RequestMapping("/api")
public class OrderController implements OrderAPI {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MappingService mappingService;

    @Autowired
    private ElectrumService electrumService;


    @Override
    public ResponseEntity<OrderDTO> getProduct(@PathVariable Long id) {
        Order order = orderService.getProductById(id);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        OrderDTO orderDTO = mappingService.toDTO(order);

        SendRequest sendRequest = electrumService.getRequest(order.getAddress());


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
