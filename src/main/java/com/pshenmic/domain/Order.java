package com.pshenmic.domain;

import javax.persistence.*;
import java.math.BigDecimal;
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

    //btc price on the market. for example, 2000$
    @Column(nullable = false, name = "btc_rate")
    private BigDecimal btcRate;

    //Final amount in btc
    @Column(nullable = false, name = "btc_price")
    private BigDecimal btcPrice;

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, name = "memo")
    private String memo;

    @Column(nullable = false, name = "time")
    private Instant time;

    @Column(nullable = false, name = "electrum_id")
    private String electrumId;


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

    public BigDecimal getBtcRate() {
        return btcRate;
    }

    public void setBtcRate(BigDecimal btcRate) {
        this.btcRate = btcRate;
    }

    public BigDecimal getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(BigDecimal btcPrice) {
        this.btcPrice = btcPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getElectrumId() {
        return electrumId;
    }

    public void setElectrumId(String electrumId) {
        this.electrumId = electrumId;
    }
}
