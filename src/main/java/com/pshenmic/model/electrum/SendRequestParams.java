package com.pshenmic.model.electrum;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SendRequestParams {

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("memo")
    private String memo;

    @JsonProperty("force")
    private Boolean force;

    @JsonProperty("expiration")
    private int expiration;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getForce() {
        return force;
    }

    public void setForce(Boolean force) {
        this.force = force;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "SendRequestParams{" +
                "amount=" + amount +
                ", memo='" + memo + '\'' +
                ", force=" + force +
                ", expiration=" + expiration +
                '}';
    }
}
