package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pshenmic.model.electrum.GetBalanceResult;

public class ElectrumGetBalanceResponse extends ElectrumResponse {

    @JsonProperty("result")
    private GetBalanceResult result;

    public GetBalanceResult getResult() {
        return result;
    }

    public void setResult(GetBalanceResult result) {
        this.result = result;
    }
}
