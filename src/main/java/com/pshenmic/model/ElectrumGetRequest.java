package com.pshenmic.model;


import com.pshenmic.model.electrum.GetRequestParams;

public class ElectrumGetRequest extends ElectrumRequest{

    private GetRequestParams params;

    public GetRequestParams getParams() {
        return params;
    }

    public void setParams(GetRequestParams params) {
        this.params = params;
    }
}
