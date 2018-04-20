package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by debian on 6/30/17.
 * {"15m" : 2587.99, "last" : 2587.99, "buy" : 2586.74, "sell" : 2588,  "symbol" : "$"},
 */
public class BlockchainInfoCurrencyTick {
    @JsonProperty(value = "15m")
    private BigDecimal fifteenMinutesPrice;

    private BigDecimal last;

    private BigDecimal buy;

    private BigDecimal sell;

    private String symbol;


    public BigDecimal getFifteenMinutesPrice() {
        return fifteenMinutesPrice;
    }

    public void setFifteenMinutesPrice(BigDecimal fifteenMinutesPrice) {
        this.fifteenMinutesPrice = fifteenMinutesPrice;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
