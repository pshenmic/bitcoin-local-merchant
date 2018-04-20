package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pshenmic.model.electrum.SendRequestParams;

public class ElectrumSendRequest extends ElectrumRequest {

    @JsonProperty("params")
    private SendRequestParams params;


    public SendRequestParams getParams() {
        return params;
    }

    public void setParams(SendRequestParams params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ElectrumSendRequest{" +
                "params=" + params +
                '}';
    }
}



