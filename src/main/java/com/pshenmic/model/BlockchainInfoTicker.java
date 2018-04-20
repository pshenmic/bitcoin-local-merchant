package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockchainInfoTicker {

    @JsonProperty("RUB")
    BlockchainInfoCurrencyTick RUB;

    @JsonProperty("USD")
    BlockchainInfoCurrencyTick USD;

    public BlockchainInfoCurrencyTick getRUB() {
        return RUB;
    }

    public void setRUB(BlockchainInfoCurrencyTick RUB) {
        this.RUB = RUB;
    }

    public BlockchainInfoCurrencyTick getUSD() {
        return USD;
    }

    public void setUSD(BlockchainInfoCurrencyTick USD) {
        this.USD = USD;
    }
}

