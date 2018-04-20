package com.pshenmic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pshenmic.model.electrum.ErrorDTO;
import com.pshenmic.model.electrum.SendRequest;

public class ElectrumSendRequestResponse extends ElectrumResponse {

    @JsonProperty("result")
    private SendRequest result;

    private ErrorDTO error;

    public SendRequest getResult() {
        return result;
    }

    public void setResult(SendRequest result) {
        this.result = result;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }
}


