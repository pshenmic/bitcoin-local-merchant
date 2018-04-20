package com.pshenmic.repository;

import com.pshenmic.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationPriceRepository extends JpaRepository<Order, Long> {
}
