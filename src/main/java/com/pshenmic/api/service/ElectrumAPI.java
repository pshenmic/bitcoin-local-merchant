package com.pshenmic.api.service;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcParamsPassMode;
import com.pshenmic.model.electrum.SendRequest;

import java.math.BigDecimal;

public interface ElectrumAPI {

    //Basic order creation
    @JsonRpcMethod(value = "addrequest", paramsPassMode = JsonRpcParamsPassMode.OBJECT)
    SendRequest addRequest(@JsonRpcParam(value = "amount") BigDecimal amount,
                           @JsonRpcParam(value = "memo") String memo,
                           @JsonRpcParam(value = "force") Boolean force,
                           @JsonRpcParam(value = "expiration") int expiration);


    @JsonRpcMethod(value = "getrequest", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    SendRequest getRequest(@JsonRpcParam(value = "address") String address);
}