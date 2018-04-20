package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pshenmic.model.electrum.SendRequest;

public class ElectrumGetRequestResponse extends ElectrumResponse {

    @JsonProperty("result")
    private SendRequest result;

    public SendRequest getResult() {
        return result;
    }

    public void setResult(SendRequest result) {
        this.result = result;
    }
}
