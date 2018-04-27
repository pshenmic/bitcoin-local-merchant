package com.pshenmic.repository;

import com.pshenmic.domain.Order;
import com.pshenmic.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByStatus(OrderStatus status);

    //Unknown is needed because electrum node sometimes create order with this status
    @Query(value = "SELECT o FROM Order o where status = 'PENDING' or status = 'UNKNOWN'")
    List<Order> findAllPendingOrders();
}
