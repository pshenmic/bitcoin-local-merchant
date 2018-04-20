package com.pshenmic.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ElectrumGetBalanceRequest extends ElectrumRequest{

    @JsonProperty("params")
    private List<?> params;

    public List<?> getParams() {
        return params;
    }

    public void setParams(List<?> params) {
        this.params = params;
    }
}
