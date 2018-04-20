package com.pshenmic.api.service;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.pshenmic.model.electrum.SendRequest;

import java.math.BigDecimal;

public interface ElectrumAPI {

    //Basic order creation
    SendRequest addrequest(@JsonRpcParam(value = "amount") BigDecimal amount,
                           @JsonRpcParam(value = "memo") String memo,
                           @JsonRpcParam(value = "force") Boolean force,
                           @JsonRpcParam(value = "expiration") int expiration);
}