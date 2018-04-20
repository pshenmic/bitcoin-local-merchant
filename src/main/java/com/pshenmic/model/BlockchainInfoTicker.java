package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockchainInfoTicker {

    @JsonProperty("RUB")
    BlockchainInfoCurrencyTick RUB;

    public BlockchainInfoCurrencyTick getRUB() {
        return RUB;
    }

    public void setRUB(BlockchainInfoCurrencyTick RUB) {
        this.RUB = RUB;
    }
}

