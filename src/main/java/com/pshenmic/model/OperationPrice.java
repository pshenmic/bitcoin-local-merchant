package com.pshenmic.model;

import java.math.BigDecimal;

public class OperationPrice {

    private BigDecimal price;

    private BigDecimal btcRate;

    private BigDecimal btcPrice;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
}
