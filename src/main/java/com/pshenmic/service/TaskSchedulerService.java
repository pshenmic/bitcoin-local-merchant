package com.pshenmic.service;

import com.pshenmic.domain.Order;
import com.pshenmic.enums.OrderStatus;
import com.pshenmic.model.electrum.SendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskSchedulerService {

    private final Logger log = LoggerFactory.getLogger(TaskSchedulerService.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ElectrumService electrumService;

    @Autowired
    private MappingService mappingService;

    @Scheduled(fixedDelay = 15000)
    public void updateOrders() {
        log.debug("Task scheduler executed");

        List<Order> pendingOrders = orderService.getAllPendingOrders();

        pendingOrders.forEach(order -> {
            try {
                SendRequest sendRequest = electrumService.getRequest(order.getAddress());
                OrderStatus orderStatus = mappingService.toOrderStatus(sendRequest.getStatus());
                if (orderStatus == null) {
                    log.warn("Order with id {} have unmappable status {}", order.getId(), order.getStatus());
                    order.setStatus(OrderStatus.ERROR);
                    orderService.updateOrder(order);
                } else {
                    if (order.getStatus() == orderStatus) {
                        return;
                    }
                    log.info("OrderStatus have been changed for order with id {}, new status =  {}", order.getId(), order.getStatus());
                    order.setStatus(orderStatus);
                    orderService.updateOrder(order);
                }
            } catch (Exception e) {
                log.error("Error while fetching order with id {}", order.getId(), e);
                order.setStatus(OrderStatus.ERROR);
                orderService.updateOrder(order);
            }
        });
    }
}
