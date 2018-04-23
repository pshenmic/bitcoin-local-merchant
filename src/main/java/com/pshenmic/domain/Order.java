package com.pshenmic.domain;

import com.pshenmic.enums.OrderStatus;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, name = "time")
    private Instant time;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "operation_price_id")
    private OperationPrice operationPrice;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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

    public OperationPrice getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(OperationPrice operationPrice) {
        this.operationPrice = operationPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
