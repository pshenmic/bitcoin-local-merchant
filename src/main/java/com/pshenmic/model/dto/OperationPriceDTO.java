package com.pshenmic.model.dto;

import com.pshenmic.enums.Currency;

import java.math.BigDecimal;

public class OperationPriceDTO {

    private Long id;

    private BigDecimal btcPrice;

    private BigDecimal fiatRate;

    private Currency currency;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(BigDecimal btcPrice) {
        this.btcPrice = btcPrice;
    }

    public BigDecimal getFiatRate() {
        return fiatRate;
    }

    public void setFiatRate(BigDecimal fiatRate) {
        this.fiatRate = fiatRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
