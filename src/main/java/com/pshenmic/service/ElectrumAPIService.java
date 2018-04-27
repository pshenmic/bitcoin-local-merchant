package com.pshenmic.service;


import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.pshenmic.api.service.ElectrumAPI;
import com.pshenmic.model.electrum.SendRequest;
import com.pshenmic.model.electrum.SendRequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class ElectrumAPIService {

    @Autowired
    private ElectrumAPI electrumAPI;

    public SendRequest addRequest(SendRequestParams sendRequestParams) {
        return electrumAPI.addRequest(sendRequestParams.getAmount(), sendRequestParams.getMemo(), sendRequestParams.getForce(), sendRequestParams.getExpiration());
    }

    public SendRequest getRequest(String address) {
        return electrumAPI.getRequest(address);
    }

}
