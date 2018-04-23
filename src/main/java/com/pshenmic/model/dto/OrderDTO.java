package com.pshenmic.model.dto;

import com.pshenmic.enums.OrderStatus;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

public class OrderDTO {

    @NotNull
    private Long id;

    private ProductDTO product;

    private String address;

    private Instant time;

    private OperationPriceDTO operationPrice;

    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public OperationPriceDTO getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(OperationPriceDTO operationPrice) {
        this.operationPrice = operationPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
