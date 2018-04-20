package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public abstract class ElectrumResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("jsonrpc")
    private BigDecimal jsoRpc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getJsoRpc() {
        return jsoRpc;
    }

    public void setJsoRpc(BigDecimal jsoRpc) {
        this.jsoRpc = jsoRpc;
    }
}
