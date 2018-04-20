package com.pshenmic.model.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OrderDTO {

    @NotNull
    private Long id;

    @NotNull
    private BigDecimal price;

    @NotNull
    private BigDecimal btcAmount;

    @NotNull
    private BigDecimal btcRate;

    @NotNull
    private String status;

    @NotNull
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBtcAmount() {
        return btcAmount;
    }

    public void setBtcAmount(BigDecimal btcAmount) {
        this.btcAmount = btcAmount;
    }

    public BigDecimal getBtcRate() {
        return btcRate;
    }

    public void setBtcRate(BigDecimal btcRate) {
        this.btcRate = btcRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
