package com.pshenmic.domain;


import com.pshenmic.enums.Currency;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_operation_price")
public class OperationPrice {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "btc_price")
    private BigDecimal btcPrice;

    @Column(nullable = false, name = "fiat_rate")
    private BigDecimal fiatRate;

    @Column(nullable = false, name = "currency")
    @Enumerated(EnumType.STRING)
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
