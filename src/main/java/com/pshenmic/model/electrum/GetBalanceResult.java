package com.pshenmic.model.electrum;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class GetBalanceResult {

    @JsonProperty("confirmed")
    private BigDecimal confirmed;

    @JsonProperty("unconfirmed")
    private BigDecimal unconfirmed;

    public BigDecimal getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(BigDecimal confirmed) {
        this.confirmed = confirmed;
    }

    public BigDecimal getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(BigDecimal unconfirmed) {
        this.unconfirmed = unconfirmed;
    }
}
